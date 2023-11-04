package moso_homework_3_practice;

public class TV {
 	int channel;
 	int volume;

	public TV() {
		System.out.println("<2019112174 조창욱>");
		System.out.println("티비전원이 커졌습니다.");
		channel=7;//채널값 초기화
		volume=20;//볼류값 초기화
		System.out.println("현재 채널: " +channel);
		System.out.println("현재 볼륨: " +volume);
		System.out.println("");
	}
	public void turnoffTV()
	{
		System.out.println("티비 전원이 꺼졌습니다.");
	}
	
	public void volumeUp(int vol)
	{
		volume+=1;
		System.out.println("볼륨 1증가: " +volume);
	}
	public void volumeDown(int vol)
	{
		volume-=1;
		System.out.println("볼륨 1감소: " +volume);
		
	}
	public void channelUp(int chan)
	{
		channel+=1;
		System.out.println("채널 1증가: " +channel);
	}
	public void channelDown(int chan)
	{
		channel-=1;
		System.out.println("채널 1감소: " +channel);
	}
}
