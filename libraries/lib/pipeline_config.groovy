fields {
    required {
        registry           = String
        image              = String
        targets            = List
        env_credentials_id = String   // dùng trong deploy
        compose_override   = String   // dùng trong deploy
        health_url         = String   // dùng trong smoke_test
    }
    optional {
        python_version = String
        requirements   = String
        compose_file   = String
    }
}
