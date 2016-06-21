package com.demo.controller;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping
public class KaptchaController {

    @Qualifier("captchaProducer")
    @Autowired
    private Producer producer;

    @RequestMapping("/verification")
    private void kaptcha(HttpServletRequest request,
            HttpServletResponse response) {
        response.setDateHeader("Expires", 0);
        response.setHeader("Cache-Control",
            "no-store, no-cache, must-revalidate");
        response.addHeader("Cache-Control", "post-check=0, pre-check=0");
        response.setHeader("Pragma", "no-cache");
        response.setContentType("image/jpeg");
        String text = producer.createText();
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY, text);
        BufferedImage bi = producer.createImage(text);
        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();
            ImageIO.write(bi, "jpg", out);
        } catch (IOException e1) {
            e1.printStackTrace();
        } finally {
            try {
                out.close();
                out.flush();
            } catch (IOException e) {
            }
        }
    }
}
