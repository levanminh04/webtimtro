import HomePages from '@/pages/homePage.vue';
import TorenPage from '@/pages/torenPage.vue';
import { createRouter, createWebHistory } from 'vue-router'
import LoginPage from '@/pages/loginPage.vue';
import SignupPage from '@/pages/SignupPage.vue';
import PostMotelPage from '@/pages/postMotelPage.vue';
import inforAccount from '@/pages/accountPage/inforAccount.vue';
import ActiclePage from '@/pages/acticlePage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "HomePage", component: HomePages },
    { path: "/search", name: "TorenPage", component: TorenPage },
    { path: "/login", name: "LoginPage", component: LoginPage },
    { path: "/register", name: "SignupPage", component: SignupPage },
    { path: "/postMotel", name: "PostMotelPage", component: PostMotelPage },
    { path: "/account/thong-tin-ca-nhan", name: "UserProfile", component: inforAccount },
    { path: "/acticle", name: "ActiclePage", component: ActiclePage },

  ],
});

export default router
