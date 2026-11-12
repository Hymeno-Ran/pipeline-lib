void call() {
    stage('Push') {
        config.targets.each { target ->
            def name = "${config.registry}/${config.image}-${target}"
            sh "docker push ${name}:{env.IMAGE_TAG}" 
        }
    }
}