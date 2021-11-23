import { createRouter, createWebHashHistory } from 'vue-router'
import PessoaPage from "../PessoaPage.vue";
import CarroPage from "../CarroPage.vue";
import TelefonePage from "../TelefonePage.vue";

const routes = [
  {
    path: '/',
    name: 'Home',
    redirect: '/pessoa'
  },
  {
    path: '/pessoa',
    name: 'Pessoa',
    component: PessoaPage
  },
  {
    path: '/carro',
    name: 'Carro',
    component: CarroPage
  },
  {
    path: '/telefone',
    name: 'Telefone',
    component: TelefonePage
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
