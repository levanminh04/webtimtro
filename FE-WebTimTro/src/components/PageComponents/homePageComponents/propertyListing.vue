<template>
    <div class="property-listing">
      <h2 class="title">Cho thuê tại Hà Nội</h2>
      <div class="row property-list">
        <div class="col-xs-12 col-sm-12 col-md-12 col-lg-12">
          <ul class="property-items">
            <li class="property-item" v-for="(property, index) in properties" :key="index">
              <img class="lozad" :src="property.imageUrl" alt="" data-loaded="true" />
              <a href="./article.html" class="title link-overlay" gtm-event="link" gtm-cat="home" gtm-act="property-latest">{{ property.title }}</a>
              <ul class="prop-attr">
                <li><i class="fa fa-chart-area"></i>{{ property.area }} m<sup>2</sup></li>
                <li><i class="fa fa-bed"></i>{{ property.bedrooms }}</li>
                <li><i class="fa fa-bath"></i>{{ property.bathrooms }}</li>
              </ul>
              <div class="price">{{ property.price }}</div>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </template>
  
  <script>
  export default {
    name: 'PropertyListing',
    data() {
      return {
        properties: [
          {
            title: "Cho thuê dãy nhà trọ khu tái định cư êm đềm, gần kcx linh trung1 th đức.",
            imageUrl: "https://cloud.mogi.vn/images/thumb-xs/2020/06/11/339/8915f665192843efa9a7341c4816721e.jpg",
            area: 121,
            bedrooms: 8,
            bathrooms: 8,
            price: "2 triệu"
          },
          {
            title: "Bán nhà dãy nhà trọ khu tái định cư êm đềm, gần kcx linh trung1 th đức.",
            imageUrl: "https://cloud.mogi.vn/images/thumb-small/2020/08/13/161/9d92e59686d147a3b3d68a528386594f.jpg",
            area: 121,
            bedrooms: 8,
            bathrooms: 8,
            price: "2.5 triệu"
          },
          {
            title: "Cho thuê dãy nhà trọ khu tái định cư êm đềm, gần kcx linh trung1 th đức.",
            imageUrl: "https://cloud.mogi.vn/images/thumb-small/2020/07/06/349/109894f4096f4539ab1b017e867db7d6.jpg",
            area: 121,
            bedrooms: 8,
            bathrooms: 8,
            price: "5 triệu"
          },
          {
            title: "Cho thuê dãy nhà trọ khu tái định cư êm đềm, gần kcx linh trung1 th đức.",
            imageUrl: "https://cloud.mogi.vn/images/thumb-small/2020/08/28/492/e2c5e373d9e94823b28fba1f12538be3.jpg",
            area: 121,
            bedrooms: 8,
            bathrooms: 8,
            price: "3 triệu"
          },
          {
            title: "Cho thuê dãy nhà trọ khu tái định cư êm đềm, gần kcx linh trung1 th đức.",
            imageUrl: "https://cloud.mogi.vn/images/thumb-small/2020/06/28/384/28478a24b0c447b88ae2982d2e47311b.jpg",
            area: 121,
            bedrooms: 8,
            bathrooms: 8,
            price: "5 triệu"
          },
          {
            title: "Cho thuê dãy nhà trọ khu tái định cư êm đềm, gần kcx linh trung1 th đức.",
            imageUrl: "https://cloud.mogi.vn/images/thumb-xs/2020/10/05/529/8c29a982845249eb8ff43269909ea308.jpg",
            area: 121,
            bedrooms: 8,
            bathrooms: 8,
            price: "6 triệu"
          }
        ]
      }
    }
  }
  </script>
  
  