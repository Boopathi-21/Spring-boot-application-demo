node{
stage('SCM Checkout'){
 git 'https://github.com/Boopathi-21/Spring-boot-application-demo'
}
stage('Compile-Package'){
// get maven home path
def mvnHome = tool name: 'maven', type: 'maven'
sh "${mvnHome}/bin/mvn package"

}

}
