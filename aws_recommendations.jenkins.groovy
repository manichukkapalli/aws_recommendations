node(){
        stage('Git Clone'){
            git branch: 'main', url: 'https://github.com/manichukkapalli/aws_recommendations.git'
            sh 'chmod 777 /var/lib/jenkins/workspace/recommendations'
        }
        stage("AWS"){
            dir ("${env.WORKSPACE}"){
                sh 'chmod 755 ec2_recommendations.sh'
                sh './ec2_recommendations.sh'
            }
        }
    }
