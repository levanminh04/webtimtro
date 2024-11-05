<template>
  <div data-mdb-input-init class="form-outline form-white mb-4">
    <input
      :type="type"
      :id="id"
      class="form-control form-control-lg"
      v-model="inputValue"
    />
    <label class="form-label" :for="id">{{ label }}</label>
  </div>
</template>
  
  <script>
export default {
  props: {
    id: String,
    type: String,
    label: String,
  },
  data() {
    return {
      inputValue: "",
    };
  },
};
</script>
  