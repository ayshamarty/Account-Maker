
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

                stage('---redeploy stack---') {
                    steps {
                            build job: "Account-API-Deploy", wait: true

			}
		}
	}
}
