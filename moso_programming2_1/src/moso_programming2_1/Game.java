package moso_programming2_1;
import java.util.*;
abstract class Character{
	int hitPoint; //캐릭터의 체력
	int portionNumber;

	abstract void initialize();	// 체력과 물약의 수를 최대치로 초기화한다.
	abstract void attack(Character c);
	abstract int getDamage(int damage); // 특정 숫자의 데미지량을 받아 자신의 체력에 반영하며
	//필요하다면 recover() 메소드를 통해 물약을 먹고 체력을 회복하도록 한다. 
	abstract void recover(); // 물약을 먹고 체력을 캐릭터 특성에 따라 회복한다. 
	 //Barlog의 경우필요하다면 한번에 2번 물약을 먹을 수 있다.
	boolean isDie()
	{
		if(hitPoint<=0)
		{
			whoAmI();
			System.out.println(" is dead.");
			return true;
		}
		else
			return false;
		
	}// 자신이 죽었는 지 아닌지를 판단한다. 죽은 경우 “<___> is dead.” 메시지를 출력한다.
	abstract boolean needPortion(); // 지금 물약을 먹어야 하는 지를 판단하고 남은 물약이 있다면 물약을 소비한다.
	abstract void whoAmI(); // 자신이 어떤 클래스에 속하는 지를 화면에 출력한다
}
class Human extends Character
{
	private int damage=50;
	private int portion= 40;
	private int max_HP=200;
	Human() //초기화 하는 생성자
	{
		initialize();
	}
	public void initialize()
	{
		this.hitPoint=max_HP;
		this.portionNumber=5;
	}
	public void attack(Character c)
	{
		System.out.print("Human attacks with damage "+damage+". ");
		c.getDamage(damage); //상대방에게(블루 or 레드) 공격을 하면 그 상대방은 damage를 받음
	}
	@Override 	
	public int getDamage(int fdamage) {
		this.hitPoint-=fdamage; //받은 데미지 만큼 체력을줄임
		System.out.println("Human has "+this.hitPoint+" hit point now");
		if(needPortion()==true && this.hitPoint>0)
		{
			recover();
		}
		return this.hitPoint;
	}
	@Override
	void recover() {
		
		if(this.hitPoint>=max_HP)
		{
			this.hitPoint=max_HP;
		}
		this.hitPoint+=portion; //물약 만큼 회복
		this.portionNumber-=1; //물약 개수 감소
		
		System.out.println("Human eats portion and "+this.hitPoint +" hit point now.");
	}
	@Override
	boolean needPortion() {
		//물약이 필요하다는건 현재 체력이 물약을 먹어도 최대를 안넘는다는것.
		if((this.hitPoint <= (max_HP -portion)) && portionNumber>0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	void whoAmI()
	{
		System.out.print("<Human> ");
	} 
	
}

class Cyber_Daemon extends Character
{
	private int damage=40; //70프로 확률
	private int critical_damage=60;//30프로 확률
	private int portion1= 30;//70% 확률
	private int portion2= 50;//30% 확률
	private int max_HP=250;
	Cyber_Daemon() 
	{
		initialize();
	}
	public void initialize()
	{
		this.hitPoint=max_HP;
		this.portionNumber=5;
	}
	public void attack(Character c)
	{
		double randomValue=Math.random();
		if(randomValue<=0.3)
			{
				System.out.print("Cyber_Daemon attacks with damage "+critical_damage+". ");
				c.getDamage(critical_damage);
			}
		else
			{
				System.out.print("Cyber_Daemon attacks with damage "+damage+". ");
				c.getDamage(damage);
			}
	}
	@Override
	public int getDamage(int fdamage) {
		this.hitPoint-=fdamage;
		System.out.println("Cyber_Daemon has "+this.hitPoint+" hit point now");
		if(needPortion()==true && this.hitPoint>0)
		{
			recover();
		}
		return this.hitPoint;
	}
	@Override
	public void recover() {
		double randomValue=Math.random();
		if(this.hitPoint>=max_HP)
		{
			this.hitPoint=max_HP;
		}
		if(randomValue<=0.3)
			{
				this.hitPoint+=portion2;
				this.portionNumber-=1;
			}
		else
		{
			this.hitPoint+=portion1;
			this.portionNumber-=1;
		}
		
		System.out.println("Cyber eats portion and "+this.hitPoint +" hit point now.");
	}
	@Override
	public boolean needPortion() {
		if(this.hitPoint<= (max_HP -portion1) && portionNumber>0 )
		{
			return true;
		}
		else
		{
			return false;
		}

	}
	void whoAmI()
	{
		System.out.print("<Cyber Daemon> ");
	} 
	
}
class Barlog extends Character
{
	private int damage=25; //80프로 확률
	private int critical_damage=35;//20프로 확률
	private int portion= 30;//50% 확률
	private int max_HP=170;
	Barlog() 
	{
		initialize();
	}
	public void initialize()
	{
		this.hitPoint=max_HP;
		this.portionNumber=5;
	}
	public void attack(Character c)
	{
		double randomValue1=Math.random();
		double randomValue2=Math.random();
		if(randomValue1<=0.2)
			{
				System.out.print("Bar log attacks with damage "+critical_damage+". ");
				c.getDamage(critical_damage);}
		else
			{
				System.out.print("Bar log attacks with damage "+damage+". ");
				c.getDamage(damage);}
		if(randomValue2<=0.2)
		{	
			System.out.print("Bar log attacks with damage "+critical_damage+". ");
			c.getDamage(critical_damage);}
		else
		{	
			System.out.print("Bar log attacks with damage "+damage+". ");
			c.getDamage(damage);}
	}
	@Override
	public int getDamage(int fdamage) {
		this.hitPoint-=fdamage;
		System.out.println("Bar log has "+this.hitPoint+" hit point now");
		if(needPortion()==true && this.hitPoint>0)
		{
			recover();
		}
		return this.hitPoint;
	}
	@Override
	void recover() {
		if(this.hitPoint>=max_HP)
		{
			this.hitPoint=max_HP;
		}
		
		if(portionNumber==1)
		{
			this.portionNumber-=1;
			this.hitPoint+=portion;
		}
		else
		{
			this.portionNumber-=2;
			this.hitPoint+=portion*2;
		}
		System.out.println("Bar log eats portion and "+this.hitPoint +" hit point now.");
	}
	@Override
	boolean needPortion() {
		if(this.hitPoint<= (max_HP -portion*2) && portionNumber>0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	void whoAmI()
	{
		System.out.print("Barlog ");
	} 
}

class Elf extends Character
{
	private int damage=35; //70프로 확률
	private int critical_damage=70;//30프로 확률
	private int portion1= 30;//75% 확률
	private int portion2= 60;//25% 확률
	private int max_HP=180;
	Elf() 
	{
		initialize();
	}
	public void initialize()
	{
		this.hitPoint=max_HP;
		this.portionNumber=5;
	}
	public void attack(Character c)
	{
		double randomValue=Math.random();
		if(randomValue<=0.3)
			{System.out.print("Elf attacks with damage "+critical_damage+". ");
			c.getDamage(critical_damage);}
		else
			{System.out.print("Elf attacks with damage "+damage+". ");
			c.getDamage(damage);}
	}
	@Override
	public int getDamage(int fdamage) {
		this.hitPoint-=fdamage;
		System.out.println("Elf has "+this.hitPoint+" hit point now");
		if(needPortion()==true && this.hitPoint>0)
		{
			recover();
		}
		return this.hitPoint;
	}
	@Override
	void recover() {
		double randomValue=Math.random();
		if(this.hitPoint>=max_HP)
		{
			this.hitPoint=max_HP;
		}
		if(randomValue<=0.25)
			{
				this.hitPoint+=portion2;
				this.portionNumber-=1;
			}
		else
		{
			this.hitPoint+=portion1;
			this.portionNumber-=1;
		}
		
		System.out.println("Elf eats portion and "+this.hitPoint +" hit point now.");
	}
	@Override
	boolean needPortion() {
		if(this.hitPoint<= (max_HP -portion1) && portionNumber>0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	void whoAmI()
	{
		System.out.print("<Elf> ");
	} 
}
public class Game {
	public static Character battle(Character blue, Character red) 
	{
		double whoisfirst= Math.random();
		Character first=blue;
		if(whoisfirst>=0.5)
		{
			first=red;
			red=blue;
			blue=first;
		}
		while(true)
		{
				blue.attack(red);
				red.attack(blue);
				if(red.isDie()==true)
				{
					return blue;
				}
				if(blue.isDie()==true)
				{
					return red;
				}
			
		}
	}
	static void tournament(Character hu, Character cyber, Character bar, Character el)
	{
		Character firstgame_winner = battle(hu, cyber);
		System.out.print("First tournament winner : ");
		firstgame_winner.whoAmI();
		System.out.println("");	
		System.out.println("");
		
		Character secondgame_winner = battle(bar, el);
		System.out.print("Second tournament winner : ");
		secondgame_winner.whoAmI();
		System.out.println("");
		System.out.println("");
		//다시 초기화
		firstgame_winner.initialize();
		secondgame_winner.initialize();
		
		Character finalWinner = battle(firstgame_winner,secondgame_winner);
		System.out.print("Final winner : ");
		finalWinner.whoAmI();
		System.out.println("");
		System.out.println("");
	}
	
	public static void main(String[] args) {
		Human human = new Human();
		Cyber_Daemon cyber_daemon = new Cyber_Daemon();
		Barlog bar_log = new Barlog();
		Elf elf = new Elf();
		
		tournament(human,cyber_daemon,bar_log,elf);
		
	}
}
