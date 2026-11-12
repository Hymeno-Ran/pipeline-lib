// JTE validate config của app trước khi chạy pipeline.
// Field nào app truyền vào mà không khai báo ở đây -> build fail.
fields {
    required {
        registry           = String
        image              = String
        targets            = List
        env_credentials_id = String   // deploy: Secret file chứa .env
        compose_override   = String   // deploy
        health_url         = String   // smoke_test
    }
    optional {
        git_url        = String       // pre_build, bỏ trống nếu dùng Multibranch
        git_branch     = String       // pre_build, mặc định main
        python_version = String       // unit_test, mặc định 3.12
        requirements   = String       // unit_test, mặc định requirements.txt
        compose_file   = String       // deploy, mặc định docker-compose.yaml
    }
}
