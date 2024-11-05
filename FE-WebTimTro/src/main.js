
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
import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/js/bootstrap.bundle.min.js';
// import '@/assets/css/loginStyle.css'


import router from './router'

const app = createApp(App)

app.use(router)

app.mount('#app')
