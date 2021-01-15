import java.util.Random;


public class GuessingGame {
	static boolean running=false,beans=true;
	static int a;
	
	public static boolean isRunning(){
		return running;
	}
	public static String Run(){
		running=true;
		a = new Random().nextInt(200-50)+50;
		return "You decided to play JHTech's Guessing Game! All rights reserved.\nGLOBALTEXT@ ______\nGLOBALTEXT@/%%%\\\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@------------\n\nGLOBALTEXT@How much jellybeans are there in the jar?";
	}
	public static String giveAns(String s){
		if(s.equalsIgnoreCase("EAT THE BEANS!")){
			beans=false;
			a=0;
			return "You Eat The Beans...\nGLOBALTEXT@ ______\nGLOBALTEXT@/   \\\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@------------";
		}else{
			int b;
			try{
				b=Integer.parseInt(s);
			}catch(Exception e){
				return "That is not a number, sir.";
			}
			if(b == a){
				beans=true;
				running=false;
				return "We have a winner!";
			}else if(b<a){
				if(beans){
					return "Sorry sir, it is bigger.\nGLOBALTEXT@ ______\nGLOBALTEXT@/%%%\\\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@------------";
				}else{
					return "Sorry sir, it is bigger.\nGLOBALTEXT@ ______\nGLOBALTEXT@/   \\\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@------------";
				}
			}else{
				if(beans){
					return "Sorry sir, it is smaller.\nGLOBALTEXT@ ______\nGLOBALTEXT@/%%%\\\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@|%%%%|\nGLOBALTEXT@------------";
				}else{
					return "Sorry sir, it is smaller.\nGLOBALTEXT@ ______\nGLOBALTEXT@/   \\\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@|    |\nGLOBALTEXT@------------";
			}
			}
		}
	}
}
