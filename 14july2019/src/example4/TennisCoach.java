package example4;

public class TennisCoach implements Coach {

	private String name;
	private  Level level;
	public TennisCoach() {
		// TODO Auto-generated constructor stub
		super();
	}
	public String getDailyWorkout() {
		return "Practice back volley today..";
	}
	
	public void createCoach(String name, Level level) {
		this.name=name;
		System.out.println(level);
		this.level=level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	
	public String getCoachDetails() {
		StringBuilder sb=new StringBuilder();
		sb.append("Todays Workout plan:"+getDailyWorkout()+"\n");
		sb.append("Name: Of The Coach: "+getName()+"\n");
		sb.append("level of the coach is: "+level+"\n");
		sb.append("coach's level rank is: "+ level.getLevelCode());
		return sb.toString();
	}
}
