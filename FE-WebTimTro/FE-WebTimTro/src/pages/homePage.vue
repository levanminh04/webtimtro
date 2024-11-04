<template>
  <!-- NAVBAR -->
  <div class="hpc-navbar">
    <div class="container">
      <div class="row">
        <cls-navbar />
        <cls-navbarmobile />
      </div>
    </div>
  </div>
  <!-- END NAVBAR -->

  <!-- BANNER HOME SEARCH -->
  <div class="row">
    <div class="bg-page-content">
      <cls-search />
    </div>
  </div>
  <!-- END BANNER HOME SEARCH -->

  <!-- REVIEW WARD -->
  <div class="row">
    <div class="container">
      <area-review />
    </div>
  </div>
  <!-- END REVIEW WARD -->

  <!-- PROPERTI LIST -->
  <div class="row">
    <div class="container">
      <cls-property-listing />
    </div>
  </div>
  <!-- END PROPERTI LIST -->

  <!-- BANNER CONTENT -->
  <div class="row">
    <div class="container">
      <cls-banner />
    </div>
  </div>
  <!-- END BANNER CONTENT -->

  <!-- PROPERTI LIST -->
  <div class="row">
    <div class="container">
      <cls-property-listing />
    </div>
  </div>
  <!-- END PROPERTI LIST -->

  <!-- FOOTER -->
  <div class="row">
    <cls-footer />
  </div>
  <!-- END FOOTER -->
</template>
  
  <script>
import search from "@/components/PageComponents/homePageComponents/search.vue";
import areaReview from "@/components/PageComponents/homePageComponents/areaReview.vue";
import banner from "@/components/PageComponents/homePageComponents/banner.vue";
import footer from "@/components/PageComponents/homePageComponents/footer.vue";
import navbar from "@/components/PageComponents/homePageComponents/navbar.vue";
import navbarMobile from "@/components/PageComponents/homePageComponents/navbarMobile.vue";
import propertyListing from "@/components/PageComponents/homePageComponents/propertyListing.vue";

export default {
  name: "homePages",
  components: {
    "cls-search": search,
    "cls-navbar": navbar,
    "cls-navbarmobile": navbarMobile,
    "area-review": areaReview,
    "cls-property-listing": propertyListing,
    "cls-footer": footer,
    "cls-banner": banner,
  },
  data() {
    return {
      message: "vooc code toi it thoi cac bo F12 =)))",
    };
  },
  mounted() {
    // Bạn có thể thêm các script cần thiết ở đây
  },
};
</script>