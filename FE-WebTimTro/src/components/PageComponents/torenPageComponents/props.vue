<template>
  <ul class="props">
    <li v-for="(property, index) in properties" :key="index">
      <div class="prop-img">
        <img class="lozad" :src="property.image" />
      </div>
      <div class="prop-info">
        <h2 class="prop-title">
          <a class="link-overlay" @click="toArticlePage">{{
            property.title
          }}</a>
        </h2>
        <div class="prop-addr">{{ property.address }}</div>
        <ul class="prop-attr">
          <li>
            <i class="fa fa-chart-area"></i>{{ property.area }} m<sup>2</sup>
          </li>
          <li><i class="fa fa-bed"></i>{{ property.beds }}</li>
          <li><i class="fa fa-bath"></i>{{ property.baths }}</li>
        </ul>
        <div class="price">{{ property.price }}</div>
        <div class="prop-extra">
          <div class="prop-created">
            <ul>
              <li>Ngày đăng:</li>
              <li>{{ property.datePosted }}</li>
            </ul>
          </div>
          <div class="favorite">
            <ul>
              <li><i class="fas fa-phone-alt"></i></li>
              <li class="call-tlphone">{{ property.phone }}</li>
              <li><i class="far fa-heart"></i></li>
            </ul>
          </div>
        </div>
      </div>
    </li>
  </ul>
</template>

<script>
export default {
  name: "Props",
  data() {
    return {
      properties: [
        {
          image:
            "https://cloud.mogi.vn/images/thumb-small/2020/04/03/082/ee32c6204b6546e7a732b07d0022eaa5.jpg",
          title:
            "Căn hộ dịch vụ cao cấp đầy đủ tiện nghi nội thất trung tâm Q.1",
          address: "Nguyễn Phi Khanh, Phường Tân Định, Quận 1, TPHCM",
          area: 121,
          beds: 8,
          baths: 8,
          price: "6 triệu",
          datePosted: "Hôm nay",
          phone: "0964341***",
          link: "./article.html",
        },
        // Bạn có thể thêm các đối tượng bất động sản khác tại đây...
        {
          image:
            "https://cloud.mogi.vn/images/thumb-small/2020/07/16/407/9a1dc3b40a6e47b2a3d1a5c4dd9da206.jpg",
          title:
            "Căn hộ dịch vụ cao cấp đầy đủ tiện nghi nội thất trung tâm Q.1",
          address: "Nguyễn Phi Khanh, Phường Tân Định, Quận 1, TPHCM",
          area: 121,
          beds: 8,
          baths: 8,
          price: "6 triệu",
          datePosted: "Hôm nay",
          phone: "0964341***",
          link: "./article.html",
        },
      ],
    };
  },
  methods: {
    toArticlePage() {
      this.$router.push("/article");
    },
  },
};
</script>

