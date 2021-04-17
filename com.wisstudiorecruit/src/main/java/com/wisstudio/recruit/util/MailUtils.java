package com.wisstudio.recruit.util;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 98333
 */
public class MailUtils {
    public static void main(String[] args) {
        sendMail("983338078@qq.com","test");

    }
    /**
     * 外网邮件发送
     *
     * @param toSomeone 收件人邮箱地址 收件人@xx.com
     * @param code 传入的验证码
     */
    public static void sendMail(String toSomeone, String code) {
        Properties pro=new Properties();
        FileInputStream in = null;
        try {
            in = new FileInputStream("src/main/resources/emailconfig.properties");
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                assert in != null;
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        String myEmail = pro.getProperty("myEmail");
        String myPassword = pro.getProperty("myPassword");
        // Session对象:
        Properties props = new Properties();
        // 设置主机地址
        props.setProperty("mail.smtp.host", "smtp.qq.com");
        props.setProperty("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.starttls.enable", "true");
        // 2.产生一个用于邮件发送的Session对象
        Session session = Session.getInstance(props);
        // Message对象:
        Message message = new MimeMessage(session);
        // 设置发件人：
        try {
            // 4.设置消息的发送者
            message.setFrom(new InternetAddress(myEmail));
            // 5.设置消息的接收者
            Address toAddr = new InternetAddress(toSomeone);
            // 设置接收对象
            message.setRecipient(MimeMessage.RecipientType.TO, toAddr);
            // 6.设置邮件标题
            message.setSubject("来自 " + myEmail + " 的安全验证码");
            // 7.设置正文
            message.setContent("这里是邮件的正文信息\n\n您的验证码为：" + code, "text/html;charset=UTF-8");
            // 8.准备发送
            Transport transport = session.getTransport("smtp");
            // 9.设置火箭的发射目标（第三个参数就是你的邮箱授权码）
            transport.connect("smtp.qq.com", myEmail, myPassword);
            // 10.发送
            transport.sendMessage(message, message.getAllRecipients());
            // Transport对象:
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String generateRandomCode(int length) {
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        while (sb.length() < length) {
            // 0 ~ s.length()-1
            int index = (new java.util.Random()).nextInt(s.length());
            // 处理重复字符：每个新的随机字符在 sb 中使用indexOf()查找下标值，-1为没找到，即不重复
            Character ch = s.charAt(index);
            if (sb.indexOf(ch.toString()) < 0) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
}
