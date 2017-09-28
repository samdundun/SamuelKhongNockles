package Chatbotproject;

public class Chatbot {
	
	private String userName;
	private Topic sam;
	private boolean chatting;
	
	public Chatbot() {
		sam = new ChatbotSam();
		userName = "unknown user";
	}

	public void startTalking() {
		ChatBotMain.print("welcome to our chatbot! What is your name?");
		userName = ChatBotMain.getInput();
		while(chatting) {
			ChatBotMain.print("What do you want to talk about?");
			String response = ChatBotMain.getInput();
			if(sam.isTriggered(response)) {
				chatting = false;
				sam.startChatting();
			}
			else {
				ChatBotMain.print("I'm sorry. I don't understand");
			}
		}
		
	}

}
