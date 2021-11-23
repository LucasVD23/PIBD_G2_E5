<template>
  <div id="cadastro">
    <div class="sub-title">Cadastrar Telefone</div>
    <q-form @submit="onSubmit" @reset="form_reset()" class="q-gutter-sm">
      <div class="row">
        <q-input
          filled
          v-model="cod"
          label="Código da pessoa"
          lazy-rules
          class="col"
        />
        <q-input
          filled
          v-model="telefone"
          label="Telefone"
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
    <div class="sub-title">Consultar Telefone</div>
    <div class="row">
      <q-expansion-item expand-separator label="Pesquisar utilizando:">
        <q-checkbox
          disable
          :v-model="true"
          label="Código da pessoa"
        ></q-checkbox>
      </q-expansion-item>
      <q-input
        filled
        v-model="search_content"
        :label="`Digite o telefone`"
        hint="*Deixar em branco para consultar por todos os telefones"
      />
    </div>
    <q-btn label="Consultar" color="primary" />
  </div>
</template>

<script>
import { ref } from "@vue/reactivity";
export default {
  setup() {
    let cod = ref("");
    let telefone = ref("");
    let search_content = ref("");
    return {
      cod,
      telefone,
      search_content,
      form_reset() {
        this.cod = this.telefone = "";
      },
    };
  },
};
</script>

<style>
</style>