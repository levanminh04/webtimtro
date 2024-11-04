import homePages from '@/pages/homePage.vue';
import TorenPage from '@/pages/torenPage.vue';
import { createRouter, createWebHistory } from 'vue-router'


const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    { path: "/", name: "HomePage", component: homePages },
    { path: "/search", name: "TorenPage", component: TorenPage }
    
  ],
});

export default router
