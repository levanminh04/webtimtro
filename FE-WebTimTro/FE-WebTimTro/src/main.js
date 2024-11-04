
import { createApp } from 'vue'
import App from './App.vue'
import '@/assets/css/torent.css';
import '@/assets/slick-master/slick/slick.css';
import '@/assets/slick-master/slick/slick-theme.css';
import 'slick-carousel/slick/slick.min.js';
import 'slick-carousel/slick/slick-theme.css';
import '@/assets/css/bootstrap.min.css'
import '@/assets/css/style.css';
import 'bootstrap';
import router from './router'

const app = createApp(App)

app.use(router)

app.mount('#app')
