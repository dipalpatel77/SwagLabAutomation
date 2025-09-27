pipeline {
    agent any

    tools {
        maven 'M3'
        jdk 'JDK17'
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main',
                url: 'https://github.com/dipalpatel77/SwagLabAutomation.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
            post {
                always {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'target/site/allure-maven-plugin']]
                    ])
                }
            }
        }

        stage('Reports') {
            steps {
                script {
                    junit 'target/surefire-reports/*.xml'
                }
            }
        }
    }

    post {
        always {
            emailext (
                subject: "SwagLab Tests: ${currentBuild.result?:'SUCCESS'} - Build #${env.BUILD_NUMBER}",
                body: """Check console output at ${env.BUILD_URL}

                Allure Report: ${env.BUILD_URL}allure/
                """,
                to: 'team@yourcompany.com'
            )
        }
    }
}