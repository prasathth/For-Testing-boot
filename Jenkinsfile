pipeline{
    agent any
    stages{
      stage('prepare'){
        step{
            sh "'/Users/pramohan3/Downloads/apache-maven-3.6.3/bin/mvn' clean"
            echo 'prepare stage'
        }
      }
      stage('execute'){
        step{
            echo 'execute stage'
            sh "'/Users/pramohan3/Downloads/apache-maven-3.6.3/bin/mvn' package"
         }
       }
      stage('deploy'){
        step{
          echo 'deploy stage'
        }
      }
   }
}
