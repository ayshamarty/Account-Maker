
pipeline{
	agent any
        stages{
		stage('---build---'){
                        steps{
                               sh "docker build -t ayshamarty/account-maker ."
                        }
                }
		stage('---push---'){
			steps{
				sh "docker push ayshamarty/account-maker"
			}
		}
	}
}
