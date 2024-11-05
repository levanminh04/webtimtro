import HomePages from '@/pages/homePage.vue';
import TorenPage from '@/pages/torenPage.vue';
import { createRouter, createWebHistory } from 'vue-router'
import LoginPage from '@/pages/loginPage.vue';
import SignupPage from '@/pages/SignupPage.vue';

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "HomePage", component: HomePages },
    { path: "/search", name: "TorenPage", component: TorenPage },
    { path: "/login", name: "LoginPage", component: LoginPage },
    { path: "/register", name: "SignupPage", component: SignupPage }
  ],
});

export default router
