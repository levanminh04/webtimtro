<template>
  <button
    type="button"
    data-mdb-button-init
    data-mdb-ripple-init
    class="btn btn-link btn-floating mx-1"
  >
    <i :class="'fab fa-' + icon"></i>
  </button>
</template>
  
  <script>
export default {
  props: {
    icon: String,
  },
};
</script>
  