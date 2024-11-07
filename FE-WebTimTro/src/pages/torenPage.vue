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

  <!-- SEARCH NAVBAR -->
  <cls-search-navbar />

  <!-- BREADCRUMB -->
  <cls-breadcrumb />

  <!-- PAGE CONTENT -->
  <div class="mg-page-content">
    <div class="container">
      <div class="row">
        <div class="col-xs-12 col-sm-12 col-md-8 col-lg-8">
          <div id="page-header">
            <h1 class="page-title">
              Thuê phòng trọ 2020 giá rẻ tại Việt Nam, giá thuê mới nhất
            </h1>
          </div>
          <div class="property-list">
            <cls-result-list />
            <cls-props />
            <cls-pagination />
          </div>
        </div>
        <div class="col-xs-12 col-sm-12 col-md-4 col-lg-4">
          <cls-banner-widget />
          <cls-kinds-of-house />
          <cls-city-area />
        </div>
      </div>
    </div>
  </div>
  <!-- FOOTER -->
  <cls-footer />
</template>
  
  <script>
import bannerWidget from "@/assets/toren_components/bannerWidget.vue";
import breadcrumb from "@/assets/toren_components/breadcrumb.vue";
import cityArea from "@/assets/toren_components/cityArea.vue";
import kindsOfHouse from "@/components/PageComponents/torenPageComponents/kindsOfHouse.vue";
import pagination from "@/components/PageComponents/torenPageComponents/pagination.vue";
import props from "@/components/PageComponents/torenPageComponents/props.vue";
import resultList from "@/components/PageComponents/torenPageComponents/resultList.vue";
import searchNavbar from "@/assets/toren_components/searchNavbar.vue";
import navbarMobile from "@/components/PageComponents/homePageComponents/navbarMobile.vue";
import navbarToren from "@/components/PageComponents/torenPageComponents/navbarToren.vue";
import footer from "@/components/PageComponents/homePageComponents/footer.vue";

export default {
  name: "torenPage",
  components: {
    clsFooter: footer,
    clsNavbar: navbarToren,
    clsNavbarmobile: navbarMobile,
    clsSearchNavbar: searchNavbar,
    clsBreadcrumb: breadcrumb,
    clsResultList: resultList,
    clsProps: props,
    clsPagination: pagination,
    clsBannerWidget: bannerWidget,
    clsKindsOfHouse: kindsOfHouse,
    clsCityArea: cityArea,
  },
  data() {
    return {
      message: "vooc code toi it thoi cac bo F12 =)))",
    };
  },
};
</script>
  
  
  