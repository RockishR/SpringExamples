package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;

@SpringBootApplication
@RestController
public class Application {

  static class Self {
    public String href;
  }

  static class Links {
    public Self self;
  }

  static class PlayerState {
    public Integer x;
    public Integer y;
    public String direction;
    public Boolean wasHit;
    public Integer score;
  }

  static class Arena {
    public List<Integer> dims;
    public Map<String, PlayerState> state;
  }

  static class ArenaUpdate {
    public Links _links;
    public Arena arena;
  }

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @InitBinder
  public void initBinder(WebDataBinder binder) {
    binder.initDirectFieldAccess();
  }

  @GetMapping("/")
  public String index() {
    return "Let the battle begin!";
  }

  @PostMapping("/**")
  public String index(@RequestBody ArenaUpdate arenaUpdate) {
    System.out.println(arenaUpdate);
    //String[] commands = new String[]{"F", "R", "L", "T"};
    //int i = new Random().nextInt(4);
    String command = "F";
    
    
    String self = arenaUpdate._links.self.href;
    int m = arenaUpdate.arena.dims.get(0);
    int n = arenaUpdate.arena.dims.get(1);
    
    Map<String, PlayerState> users = arenaUpdate.arena.state;
	PlayerState me = users.get(self);
	
	int x = me.x;
	int y = me.y;
	
	char direction = me.direction.charAt(0);
	
	int targetX = 0;
	int targetY = 0;
	
	
    
    
    return command;
  }

}

