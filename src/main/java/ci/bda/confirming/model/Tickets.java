package ci.bda.confirming.model;

public class Tickets {
 private long id;
 private String description;

public Tickets(){
	
}

public Long getId(){
	return this.id;
}

public void setId(Long id){
this.id=id;
}

public String getDescription(){
	return this.description;
}


  public void setDescription(String description){
this.description=description;
}


}
//e295ddd889fed7ad4cbeaa752e83ca825d0f2aa8
/*
mvn sonar:sonar \
  -Dsonar.projectKey=stephanehu_confirming \
  -Dsonar.organization=stephanehu-github \
  -Dsonar.host.url=https://sonarcloud.io \
  -Dsonar.login=e295ddd889fed7ad4cbeaa752e83ca825d0f2aa8
  */