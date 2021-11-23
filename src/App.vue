<template>
  <q-layout view="hHh lpR fFf">
    <q-header elevated class="bg-primary text-white" height-hint="98">
      <q-toolbar>
        <q-toolbar-title>
          <q-avatar>
            <img src="./assets/LogoDC.png " />
          </q-avatar>
          Projeto e Implementação de Bancos de Dados - Trabalho 2
        </q-toolbar-title>
      </q-toolbar>

      <q-tabs align="center">
        <q-route-tab to="/pessoa" label="Pessoa" />
        <q-route-tab to="/carro" label="Carro" />
        <q-route-tab to="/telefone" label="Telefone" />
        <q-route-tab to="/page4" label="Amizade" />
        <q-route-tab to="/page5" label="Possui" />
      </q-tabs>
    </q-header>

    <q-page-container>
      <router-view></router-view>
    </q-page-container>
  </q-layout>
</template>

<script>
export default {
  setup() {
    return {};
  },
};
</script>