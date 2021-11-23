<template>
  <div id="cadastro">
    <div class="sub-title">Cadastrar Carro</div>
    <q-form @submit="onSubmit" @reset="form_reset()" class="q-gutter-sm">
      <div class="row">
        <q-input filled v-model="placa" label="Placa" lazy-rules class="col" />
        <q-input filled v-model="ano" label="Ano" lazy-rules class="col" />
      </div>
      <div class="row">
        <q-input filled v-model="cor" label="Cor" lazy-rules class="col" />
        <q-input
          filled
          v-model="modelo"
          label="Modelo"
          lazy-rules
          class="col"
        />
      </div>

      <div>
        <q-btn label="Cadastrar" color="primary" />
        <q-btn
          label="Reset"
          type="reset"
          color="primary"
          flat
          class="q-ml-sm"
        />
      </div>
    </q-form>
  </div>

  <div id="consulta">
    <div class="sub-title">Consultar Carro</div>
    <div class="row">
      <q-expansion-item expand-separator label="Pesquisar utilizando:">
        <q-checkbox disable :v-model="true" label="Placa"></q-checkbox>
      </q-expansion-item>
      <q-input
        filled
        v-model="search_content"
        :label="`Digite a placa`"
        hint="*Deixar em branco para consultar por todos os carros"
      />
    </div>
    <q-btn label="Consultar" color="primary" />
  </div>
</template>

<script>
import { ref } from "@vue/reactivity";
export default {
  setup() {
    let placa = ref("");
    let ano = ref("");
    let cor = ref("");
    let modelo = ref("");
    let search_content = ref("");
    return {
      placa,
      ano,
      cor,
      modelo,
      search_content,
      form_reset() {
        this.placa = this.ano = this.cor = this.modelo = "";
      },
    };
  },
};
</script>

<style>
</style>