
pipeline{
	agent any
        stages{
		stage('---build---'){
                        steps{
                               sh "docker-compose up --build -d"
                        }
                }
		stage('---push---'){
			steps{
				sh "docker push ayshamarty/account-maker"
			}
		}
	}
}
