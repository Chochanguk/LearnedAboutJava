package moso_homework_3_practice;

public class TVUser {

	public static void main(String[] args) {
		//생성자(값 초기화 및 tv 전원 키기)
		TV tv= new TV();
		//각 메소드 시행
		tv.volumeUp(tv.volume);
		tv.volumeDown(tv.volume);
		tv.channelUp(tv.channel);
		tv.channelDown(tv.channel);
		tv.channelDown(tv.channel);
		tv.turnoffTV();
	}
}
