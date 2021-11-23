<template>
  <div id="cadastro">
    <div class="sub-title">Cadastrar Pessoa</div>
    <q-form @submit="onSubmit" @reset="form_reset()" class="q-gutter-sm">
      <div class="row">
        <q-input filled v-model="name" label="Nome" class="col" />

        <div class="col">
          <q-input
            filled
            v-model="date"
            label="Data de nascimento"
            @click="date_control = true"
          />
          <q-dialog v-model="date_control">
            <q-date
              minimal
              v-if="date_control"
              v-model="date"
              @click="date_control = false"
              @hide="date_control = false"
            ></q-date>
          </q-dialog>
        </div>
      </div>

      <q-input filled v-model="homepage" label="Home Page" lazy-rules />
      <div class="row">
        <q-input filled v-model="cep" label="CEP" lazy-rules class="col" />
        <q-input
          filled
          v-model="numero"
          label="Número"
          lazy-rules
          class="col"
        />
      </div>
      <q-input filled v-model="complemento" label="Complemento" lazy-rules />

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
    <div class="sub-title">Consultar Pessoa</div>
    <div class="row">
      <q-expansion-item expand-separator label="Pesquisar utilizando:">
        <q-checkbox
          v-model="nome_ctrl"
          label="Nome"
          @click="checkbox_click('nome')"
        ></q-checkbox>
        <q-checkbox
          v-model="cod_ctrl"
          label="Código"
          @click="checkbox_click('código')"
        ></q-checkbox>
      </q-expansion-item>
      <q-input
        filled
        v-model="search_content"
        :label="`Digite o ${search_by}`"
        hint="*Deixar em branco para consultar por todas as pessoas"
      />
    </div>
    <q-btn label="Consultar" color="primary" />
  </div>
</template>

<script>
import { ref } from "@vue/reactivity";
export default {
  setup() {
    let date = ref("2021/01/01");
    let name = ref("");
    let homepage = ref("");
    let date_control = ref(false);
    let cep = ref("");
    let numero = ref(null);
    let complemento = ref("");
    let search_content = ref(null);
    let search_by = ref("nome");
    let nome_ctrl = ref(true);
    let cod_ctrl = ref(false);
    return {
      date,
      name,
      homepage,
      date_control,
      cep,
      numero,
      complemento,
      search_content,
      search_by,
      nome_ctrl,
      cod_ctrl,
      checkbox_click(option) {
        this.search_by = option;
        if (option == "nome") this.cod_ctrl = false;
        else this.nome_ctrl = false;
      },
      form_reset() {
        this.date = "2021/01/01";
        this.homepage =
          this.name =
          this.complemento =
          this.cep =
          this.numero =
            "";
      },
    };
  },
};
</script>

<style>
</style>