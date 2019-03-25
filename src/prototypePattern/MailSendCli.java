package prototypePattern;

import java.util.Random;

/**
 * 邮件类
 * 
 */
class Mail implements Cloneable {

	private String acceptName;// 收件人
	private String context;// 内容

	public String getAcceptName() {
		return acceptName;
	}

	public void setAcceptName(String acceptName) {
		this.acceptName = acceptName;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
	}

	@Override
	protected Mail clone() throws CloneNotSupportedException {
		Mail mail = (Mail) super.clone();
		return mail;
	}
}

/**
 * 发送邮件的线程
 * 
 */
class SendMail implements Runnable {
	private Mail mail;

	public SendMail(Mail mail) {
		this.mail = mail;
	}

	@Override
	public void run() {
		try {
			Mail mailClone = this.mail.clone();// 拷贝对象
			String name = getRandName();
			mailClone.setAcceptName(name);
			mailClone.setContext(name + "您好，邮件内容。。。。");
			System.out.println(Thread.currentThread().getName() + "发送邮件给-》"
					+ mailClone.getAcceptName() + ",内容为："
					+ mailClone.getContext());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getRandName() {
		String source = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sb = new StringBuffer();
		Random rand = new Random();
		for (int i = 0; i < 3; i++) {
			sb.append(source.charAt(rand.nextInt(source.length())));
		}
		return sb.toString();
	}
}

public class MailSendCli {
	public static void main(String[] args) {
		Mail mail = new Mail();// 邮件模板对象
		SendMail sender1 = new SendMail(mail);
		Thread tSender1 = new Thread(sender1, "发送线程1");

		SendMail sender2 = new SendMail(mail);
		Thread tSender2 = new Thread(sender2, "发送线程2");

		SendMail sender3 = new SendMail(mail);
		Thread tSender3 = new Thread(sender3, "发送线程3");

		tSender1.start();
		tSender2.start();
		tSender3.start();
	}
}
