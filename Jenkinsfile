pipeline{
    agent any
    stages{
      stage('prepare'){
        steps{
            sh "'/Users/pramohan3/Downloads/apache-maven-3.6.3/bin/mvn' clean"
            echo 'prepare stage'
        }
      }
      stage('execute'){
        steps{
            echo 'execute stage'
            sh "'/Users/pramohan3/Downloads/apache-maven-3.6.3/bin/mvn' package"
         }
       }
      stage('deploy'){
        steps{
          echo 'deploy stage'
        }
      }
   }
}
