import { EC2, GIT, J_QUERY, JAVA, JPA, JWT, MY_BATIS, MY_SQL, RDS, REACT, S3, SPRING_BOOT, SPRING_SECURITY, TAILWIND_CSS, THYMELEAF, VERCEL } from "../../constants/stack";

export const projects = [
    {
        title: "팀 프로젝트",
        items: [
            {
                date: "2024.09 ~ ing",
                name: "프로젝트 및 작업 관리 사이트",
                href: "https://github.com/YUJIMYUNG/cooperation",
                imgSrc: "",
                tags: [JAVA, SPRING_BOOT, SPRING_SECURITY, MY_SQL, JPA, REACT, TAILWIND_CSS, GIT, EC2, RDS]
            },
            {
                date: "2024.08",
                name: "일기 및 후기를 적을 수 있는 개인 블로그",
                href: "https://github.com/JungBear/private_blog",
                imgSrc: "/img/project/blog.png",
                tags: [JAVA, SPRING_BOOT, SPRING_SECURITY, JWT, MY_SQL, JPA, REACT, GIT, S3, RDS]
            },
            {
                date: "2024.07",
                name: "Fran's",
                href: "https://github.com/JungBear/frans?tab=readme-ov-file",
                imgSrc: "/img/project/logo_slogan.png",
                tags: [JAVA,SPRING_BOOT, SPRING_SECURITY, MY_SQL, MY_BATIS, THYMELEAF, J_QUERY, GIT, EC2, RDS]
            }
        ],
    },
]