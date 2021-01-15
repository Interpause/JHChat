
import java.util.concurrent.ThreadLocalRandom;


public class TTTAI {
	
	private char[] positions = new char[]{' ',' ',' ',' ',' ',' ',' ',' ',' '};
	private boolean[] possible = new boolean[]{true,true,true,true,true,true,true,true};//0 is first hori(from top), 1 is 2nd hori, 2 is 3rd hori, 3 is left ver, 4 is middle vert,
	//5 is right vert, 6 is from left to right diago, 7 is right to left diago(both from top down) 
	private boolean[] Enemypossible = new boolean[]{true,true,true,true,true,true,true,true};
	private int method = ThreadLocalRandom.current().nextInt(0, 8);
	private int buttonInt = 1;

	public TTTAI(){
		method = ThreadLocalRandom.current().nextInt(0, 8);
		
		
		
	
		System.out.println("TAI created");
		
			
	}
	
	
	public void write(String msg, int lmno){
		System.out.println("PROCESSING");
		
			String move = msg;
			String Messagetype = "";
			int where = -1;
			move = move.trim();
			where = move.indexOf('@');

			
				Messagetype = move.substring(0, where+1);

				move = move.substring(where+1,move.length());
				Messagetype = Messagetype.trim();
				move = move.trim();
			if(Messagetype.equalsIgnoreCase("GAME@")){
				int b1 = -1;
				if((b1 = move.indexOf(','))!=-1){
					String type = move.substring(0, b1+1);
					move = move.substring(b1+1,move.length());
					move = move.trim();
					type = type.trim();
					if(type.equals("x,")){
						positions[Integer.parseInt(move)-1]='x';
						switch(Integer.parseInt(move)){
							case 1:
								possible[0] = false;
								possible[3] = false;
								possible[6] = false;
								break;
							case 2:
								possible[0] = false;
								possible[4] = false;
								break;
							case 3:
								possible[0] = false;
								possible[5] = false;
								possible[7] = false;
								break;
							case 4:
								possible[1] = false;
								possible[3] = false;
								break;
							case 5:
								possible[1] = false;
								possible[4] = false;
								possible[6] = false;
								possible[7] = false;
								break;
							case 6:
								possible[1] = false;
								possible[5] = false;
								break;
							case 7:
								possible[2]= false;
								possible[3]=false;
								possible[7]=false;
								break;
							case 8:
								possible[2]=false;
								possible[4]=false;
								break;
							case 9:
								possible[2]=false;
								possible[5]=false;
								possible[6]=false;	
								break;
						}
						System.out.println("possibilties checked");
					}else if(type.equals("o,")){
						positions[Integer.parseInt(move)-1]='o';
						System.out.println("map udated");
						
						
							switch(Integer.parseInt(move)){
								case 1:
									Enemypossible[0] = false;
									Enemypossible[3] = false;
									Enemypossible[6] = false;
									break;
								case 2:
									Enemypossible[0] = false;
									Enemypossible[4] = false;
									break;
								case 3:
									Enemypossible[0] = false;
									Enemypossible[5] = false;
									Enemypossible[7] = false;
									break;
								case 4:
									Enemypossible[1] = false;
									Enemypossible[3] = false;
									break;
								case 5:
									Enemypossible[1] = false;
									Enemypossible[4] = false;
									Enemypossible[6] = false;
									Enemypossible[7] = false;
									break;
								case 6:
									Enemypossible[1] = false;
									Enemypossible[5] = false;
									break;
								case 7:
									Enemypossible[2]= false;
									Enemypossible[3]=false;
									Enemypossible[7]=false;
									break;
								case 8:
									Enemypossible[2]=false;
									Enemypossible[4]=false;
									break;
								case 9:
									Enemypossible[2]=false;
									Enemypossible[5]=false;
									Enemypossible[6]=false;			
									break;
							}
							System.out.println("possibilties checked");
							
					}	
				}else if(move.equals("ON")){
					System.out.println("move calculating");
					System.out.println(possible);
					
					
						boolean anyLeft = false;
						
						
						
						for(boolean c: possible){
							if(c){
								anyLeft=true;
							}
						}
						
							
						if(!anyLeft){
							System.out.println("NO COMBINATION LEFT AHHH");
							for(int i = 0; i<9;i++){
								if(positions[i]==' '){
									buttonInt = i+1;
									break;
								}
							}
						}else if(!possible[method]){
							method = ThreadLocalRandom.current().nextInt(0, 8);
						}else if(possible[method]){
							int b = -1;
							switch(method){
								case 0:
									while(true){
										b = ThreadLocalRandom.current().nextInt(0, 3);
										if(positions[b]!=' '){
											b = ThreadLocalRandom.current().nextInt(0, 3);
										}else{
											buttonInt = b+1;
											break;
										}
									}
									break;
								case 1:
									while(true){
										b = ThreadLocalRandom.current().nextInt(3, 6);
										if(positions[b]!=' '){
											b = ThreadLocalRandom.current().nextInt(3, 6);
										}else{
											buttonInt = b+1;
											break;
										}
									}
									break;
								case 2:
									while(true){
										b = ThreadLocalRandom.current().nextInt(6, 9);
										if(positions[b]!=' '){
											b = ThreadLocalRandom.current().nextInt(6, 9);
										}else{
											buttonInt = b+1;
											break;
										}
									}
									break;
								case 3:
										switch(ThreadLocalRandom.current().nextInt(1, 4)){
											case 1:
												if(positions[0]==' '){
													buttonInt = 1;
													break;
												}else{}
											case 2:
												if(positions[3]==' '){
													buttonInt = 4;
													break;
												}else{}
											case 3:
												if(positions[6]==' '){
													buttonInt = 7;
													break;
												}else{}
											default:
												if(positions[0]==' '){
													buttonInt = 1;
													break;
												}else{
													buttonInt = 4;
													break;
												}
								
							}
										break;
								case 4:
									switch(ThreadLocalRandom.current().nextInt(1, 4)){
									case 1:
										if(positions[1]==' '){
											buttonInt = 2;
											break;
										}else{}
									case 2:
										if(positions[4]==' '){
											buttonInt = 5;
											break;
										}else{}
									case 3:
										if(positions[7]==' '){
											buttonInt = 8;
											break;
										}else{}
									default:
										if(positions[1]==' '){
											buttonInt = 2;
											break;
										}else{
											buttonInt = 5;
											break;
										}
						
					}
								break;
								case 5:
									switch(ThreadLocalRandom.current().nextInt(1, 4)){
									case 1:
										if(positions[2]==' '){
											buttonInt = 3;
											break;
										}else{}
									case 2:
										if(positions[5]==' '){
											buttonInt = 6;
											break;
										}else{}
									case 3:
										if(positions[8]==' '){
											buttonInt = 9;
											break;
										}else{}
									default:
										if(positions[2]==' '){
											buttonInt = 3;
											break;
										}else{
											buttonInt = 6;
											break;
										}
						
					}
								break;
								case 6:
									switch(ThreadLocalRandom.current().nextInt(1, 4)){
									case 1:
										if(positions[0]==' '){
											buttonInt = 1;
											break;
										}else{}
									case 2:
										if(positions[4]==' '){
											buttonInt = 5;
											break;
										}else{}
									case 3:
										if(positions[8]==' '){
											buttonInt = 9;
											break;
										}else{}
									default:
										if(positions[0]==' '){
											buttonInt = 1;
											break;
										}else{
											buttonInt = 5;
											break;
										}
						
					}
								break;
								case 7:
									switch(ThreadLocalRandom.current().nextInt(1, 4)){
									case 1:
										if(positions[2]==' '){
											buttonInt = 3;
											break;
										}else{}
									case 2:
										if(positions[4]==' '){
											buttonInt = 5;
											break;
										}else{}
									case 3:
										if(positions[6]==' '){
											buttonInt = 7;
											break;
										}else{}
									default:
										if(positions[2]==' '){
											buttonInt = 3;
											break;
										}else{
											buttonInt = 5;
											break;
										}
						
					}
								break;
						}
							
					
				}
						int i1 = 0;
					for(boolean c:Enemypossible){
						
						if(c){
							int x1 = 0;
							switch(i1){
							case 0:
								if(positions[0]=='x'){
									x1++;
								}
								if(positions[1]=='x'){
									x1++;
								}
								if(positions[2]=='x'){
									x1++;
								}
								if(x1==2){
									if(positions[0]==' '){
										buttonInt = 1;
									}
									if(positions[1]==' '){
										buttonInt = 2;
									}
									if(positions[2]==' '){
										buttonInt = 3;
									}
								}
								break;
							case 1:
								if(positions[3]=='x'){
									x1++;
								}
								if(positions[4]=='x'){
									x1++;
								}
								if(positions[5]=='x'){
									x1++;
								}
								if(x1==2){
									if(positions[3]==' '){
										buttonInt = 4;
									}
									if(positions[4]==' '){
										buttonInt = 5;
									}
									if(positions[5]==' '){
										buttonInt = 6;
									}
								}
								
								break;
							case 2:
								if(positions[6]=='x'){
									x1++;
								}
								if(positions[7]=='x'){
									x1++;
								}
								if(positions[8]=='x'){
									x1++;
								}
								if(x1==2){
									if(positions[6]==' '){
										buttonInt = 7;
									}
									if(positions[7]==' '){
										buttonInt = 8;
									}
									if(positions[8]==' '){
										buttonInt = 9;
									}
								}
								
								break;
							case 3:
								if(positions[0]=='x'){
									x1++;
								}
								if(positions[3]=='x'){
									x1++;
								}
								if(positions[6]=='x'){
									x1++;
								}
								if(x1==2){
									if(positions[0]==' '){
										buttonInt = 1;
									}
									if(positions[3]==' '){
										buttonInt = 4;
									}
									if(positions[6]==' '){
										buttonInt = 7;
									}
								}
								
								break;
							case 4:
								if(positions[1]=='x'){
									x1++;
								}
								if(positions[4]=='x'){
									x1++;
								}
								if(positions[7]=='x'){
									x1++;
								}
								if(x1==2){
									if(positions[1]==' '){
										buttonInt = 2;
									}
									if(positions[4]==' '){
										buttonInt = 5;
									}
									if(positions[7]==' '){
										buttonInt = 8;
									}
								}
								
								break;
							case 5:
								if(positions[2]=='x'){
									x1++;
								}
								if(positions[5]=='x'){
									x1++;
								}
								if(positions[8]=='x'){
									x1++;
								}
								if(x1==2){
									if(positions[2]==' '){
										buttonInt = 3;
									}
									if(positions[5]==' '){
										buttonInt = 6;
									}
									if(positions[8]==' '){
										buttonInt = 9;
									}
								}
								
								break;
							case 6:
								if(positions[0]=='x'){
									x1++;
								}
								if(positions[4]=='x'){
									x1++;
								}
								if(positions[8]=='x'){
									x1++;
								}
								if(x1==2){
									if(positions[0]==' '){
										buttonInt = 1;
									}
									if(positions[4]==' '){
										buttonInt = 5;
									}
									if(positions[8]==' '){
										buttonInt = 9;
									}
								}
								
								break;
							case 7:
								if(positions[2]=='x'){
									x1++;
								}
								if(positions[4]=='x'){
									x1++;
								}
								if(positions[6]=='x'){
									x1++;
								}
								if(x1==2){
									if(positions[2]==' '){
										buttonInt = 3;
									}
									if(positions[4]==' '){
										buttonInt = 5;
									}
									if(positions[6]==' '){
										buttonInt = 7;
									}
								}
								
								break;
							}
							
							
						}
						i1++;
					}
					i1 = 0;
					for(boolean c:possible){
					
					if(c){
						int x1 = 0;
						switch(i1){
						case 0:
							if(positions[0]=='o'){
								x1++;
							}
							if(positions[1]=='o'){
								x1++;
							}
							if(positions[2]=='o'){
								x1++;
							}
							if(x1==2){
								if(positions[0]==' '){
									buttonInt = 1;
								}
								if(positions[1]==' '){
									buttonInt = 2;
								}
								if(positions[2]==' '){
									buttonInt = 3;
								}
							}
							break;
						case 1:
							if(positions[3]=='o'){
								x1++;
							}
							if(positions[4]=='o'){
								x1++;
							}
							if(positions[5]=='o'){
								x1++;
							}
							if(x1==2){
								if(positions[3]==' '){
									buttonInt = 4;
								}
								if(positions[4]==' '){
									buttonInt = 5;
								}
								if(positions[5]==' '){
									buttonInt = 6;
								}
							}
							
							break;
						case 2:
							if(positions[6]=='o'){
								x1++;
							}
							if(positions[7]=='o'){
								x1++;
							}
							if(positions[8]=='o'){
								x1++;
							}
							if(x1==2){
								if(positions[6]==' '){
									buttonInt = 7;
								}
								if(positions[7]==' '){
									buttonInt = 8;
								}
								if(positions[8]==' '){
									buttonInt = 9;
								}
							}
							
							break;
						case 3:
							if(positions[0]=='o'){
								x1++;
							}
							if(positions[3]=='o'){
								x1++;
							}
							if(positions[6]=='o'){
								x1++;
							}
							if(x1==2){
								if(positions[0]==' '){
									buttonInt = 1;
								}
								if(positions[3]==' '){
									buttonInt = 4;
								}
								if(positions[6]==' '){
									buttonInt = 7;
								}
							}
							
							break;
						case 4:
							if(positions[1]=='o'){
								x1++;
							}
							if(positions[4]=='o'){
								x1++;
							}
							if(positions[7]=='o'){
								x1++;
							}
							if(x1==2){
								if(positions[1]==' '){
									buttonInt = 2;
								}
								if(positions[4]==' '){
									buttonInt = 5;
								}
								if(positions[7]==' '){
									buttonInt = 8;
								}
							}
							
							break;
						case 5:
							if(positions[2]=='o'){
								x1++;
							}
							if(positions[5]=='o'){
								x1++;
							}
							if(positions[8]=='o'){
								x1++;
							}
							if(x1==2){
								if(positions[2]==' '){
									buttonInt = 3;
								}
								if(positions[5]==' '){
									buttonInt = 6;
								}
								if(positions[8]==' '){
									buttonInt = 9;
								}
							}
							
							break;
						case 6:
							if(positions[0]=='o'){
								x1++;
							}
							if(positions[4]=='o'){
								x1++;
							}
							if(positions[8]=='o'){
								x1++;
							}
							if(x1==2){
								if(positions[0]==' '){
									buttonInt = 1;
								}
								if(positions[4]==' '){
									buttonInt = 5;
								}
								if(positions[8]==' '){
									buttonInt = 9;
								}
							}
							
							break;
						case 7:
							if(positions[2]=='o'){
								x1++;
							}
							if(positions[4]=='o'){
								x1++;
							}
							if(positions[6]=='o'){
								x1++;
							}
							if(x1==2){
								if(positions[2]==' '){
									buttonInt = 3;
								}
								if(positions[4]==' '){
									buttonInt = 5;
								}
								if(positions[6]==' '){
									buttonInt = 7;
								}
							}
							
							break;
						}
						
						
					}
					i1++;
				}
					while(true){
						if(positions[buttonInt-1]!=' '){
							buttonInt = ThreadLocalRandom.current().nextInt(1, 10);
						}else{
							break;
						}
					}
					System.out.println(buttonInt);
				}else if(move.equals("RESET")){
				}
			
			
			
		}
	}
		
		
	
	public int getMove(){
		System.out.println(buttonInt);
		return buttonInt;
		
	}
	
		
	}
	

