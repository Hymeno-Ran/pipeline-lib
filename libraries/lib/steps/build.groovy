void call() {
    stage('Build') {
        config.targets.each { target ->
            def name = "${config.registry}/${config.image}-${target}"
            sh "docker build --target ${target} -t ${name}:${env.BUILD_NUMBER} ."
        }
    }
}
