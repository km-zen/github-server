package com.githubservertask;

import com.githubservertask.domain.proxy.GitHubProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GithubServerTaskApplication {

	@Autowired
    GitHubProxy gitHubProxy;

	public static void main(String[] args) {
		SpringApplication.run(GithubServerTaskApplication.class, args);
	}

//	@EventListener(ApplicationStartedEvent.class)
//	public void makeRequestToBankApi(){
//		List<Repo> repos = gitHubProxy.getReposFromUser("km-zen","application/vnd.github+json");
//		Map<Repo,List<Branch>> repoMap = new HashMap<>();
//		for (Repo repo : repos){
//			repoMap.put(repo,gitHubProxy.getBranchesFromRepo(repo.name(),"application/vnd.github+json"));
//		}
//		System.out.println(repoMap);
//	}

}
