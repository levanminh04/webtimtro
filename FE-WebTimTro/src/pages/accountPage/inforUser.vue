<template>
  <SideBar />
</template>
  
  <script>
import sideBar from "@/components/PageComponents/userPageComponents/sideBar.vue";
import formData from "@/components/PageComponents/userPageComponents/formData.vue";
export default {
  name: "UserPage",
  components: {
    SideBar: sideBar,
    formData: formData,
  },
};
</script>
  
  <style scoped>
</style>
  