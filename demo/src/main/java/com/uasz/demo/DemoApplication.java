package com.uasz.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.uasz.demo.Modele.Maquette.EC;
import com.uasz.demo.Modele.Maquette.UE;
import com.uasz.demo.Repository.Maquette.ECRepository;
import com.uasz.demo.Repository.Maquette.UERepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	@Autowired
    private UERepository ueRepository;
    @Autowired
    private ECRepository ecRepository;

    @Override
    public void run(String... Args ) throws Exception{
        ueRepository.save(new UE(null,"reseau et telecom","INF351","matier un peu complexe",4,8,null,null,null));
        ueRepository.save(new UE(null,"Genie Logiciel Avance","INF352","matier un peu complexe",3,8,null,null,null));
        ueRepository.save(new UE(null,"base de donnee","INF353","matier un peu complexe",4,6,null,null,null));
        ueRepository.save(new UE(null,"DAOS","INF354","matier  complexe",4,8,null,null,null));
        ueRepository.save(new UE(null,"DAOS","INF354","matier  complexe",4,8,null,null,null));
        ueRepository.save(new UE(null,"administration reseau","INF355","matier que je n'apprend pas ",4,8,"01-02-2024",null,null));
        ueRepository.save(new UE(null,"Anglais","INF356","surtout avec la video la ",2,8,"01-02-2024",null,null));
        ueRepository.save(new UE(null,"securite reseau","INF357","la mome youssou faye veux nous tuer",4,8,"01-02-2024",null,null));
        // ecRepository.save(new EC(null,"reseau et telecom","INF3311",24,32,24,48,4,"fegdg","reseau et telecom",null))
        
    }

}
