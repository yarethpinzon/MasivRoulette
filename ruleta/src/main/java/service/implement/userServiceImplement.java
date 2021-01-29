package service.implement;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.example.demo.entity.roulette;
import com.example.demo.entity.user;
import com.example.demo.repository.userRepository;
import com.example.demo.repository.rouletteRepository;

import service.userService;
@Service("userService")
public class userServiceImplement implements userService{
	@Autowired
	@Qualifier("UserRepository")
	private userRepository UserRepository;
	@Override
	public List<user> listAllUsers() {
		return UserRepository.findAll();
	}
	@Override
	public user adduser(user useR) {
		return UserRepository.save(useR);
	}
	@Autowired
	@Qualifier("rouletteRepository")
	private userRepository rouletteRepository;
	@Override
	public List<roulette> listAllroulette() {
		return rouletteRepository.findAll();
	}
	@Override
	public roulette adduser(roulette Roulette) {
		return rouletteRepository.save(Roulette);
	}
}
