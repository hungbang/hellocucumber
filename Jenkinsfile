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

        stage ('Compile Stage') {
            steps {
                container('maven') {
                    sh 'mvn clean install'
                }
            }
        }
        stage ('Test Stage') {
            steps {
               container('maven') {
                    sh 'mvn test'
               }
            }
        }


        stage ('Cucumber Reports') {
            steps {
                cucumber buildStatus: "UNSTABLE",
                    fileIncludePattern: "**/cucumber.json",
                    jsonReportDirectory: 'target'
            }

        }

    }

    post {
        always {
            publishHTML (target: [
            reportDir: 'test-output/extent-reports', reportFiles: '*.html', reportLink: 'Extent Reports'
            ])
        }
    }

}