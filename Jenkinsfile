pipeline{

    agent {
        kubernetes {
          yaml '''
            apiVersion: v1
            kind: Pod
            metadata:
              labels:
                jenkins: agent
            spec:
              containers:
              - name: maven
                image: maven:3.8.6-amazoncorretto-11
                command:
                - cat
                tty: true
            '''
        }
      }

    stages {
        stage ('Test Stage') {
            steps {
               container('maven') {
                    sh 'mvn test'
               }
            }
        }


        stage ('Generate HTML Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    reportTitle: 'Cucumber report',
                    fileIncludePattern: "**/*.json",
                    jsonReportDirectory: 'target'
            }

        }

    }
}