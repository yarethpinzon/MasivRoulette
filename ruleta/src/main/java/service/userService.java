package service;
import java.util.List;
import com.example.demo.entity.roulette;
import com.example.demo.entity.user;
public interface userService {
	public abstract List<user> listAllUsers();
	public abstract user adduser(user useR);
	public abstract List<roulette> listAllroulette();
	public abstract roulette adduser(roulette Roulette);
}
