webpackJsonp([2],{"3Lce":function(e,t,r){"use strict";t.a={errorSessionId:"-1",theUserImgFront:"http://42.193.3.41:7899/img/"}},CwSZ:function(e,t,r){"use strict";var n=r("p8xL"),o=r("XgCd"),i={brackets:function(e){return e+"[]"},indices:function(e,t){return e+"["+t+"]"},repeat:function(e){return e}},a=Date.prototype.toISOString,s={delimiter:"&",encode:!0,encoder:n.encode,encodeValuesOnly:!1,serializeDate:function(e){return a.call(e)},skipNulls:!1,strictNullHandling:!1},l=function e(t,r,o,i,a,l,c,u,f,d,p,m){var y=t;if("function"==typeof c)y=c(r,y);else if(y instanceof Date)y=d(y);else if(null===y){if(i)return l&&!m?l(r,s.encoder):r;y=""}if("string"==typeof y||"number"==typeof y||"boolean"==typeof y||n.isBuffer(y))return l?[p(m?r:l(r,s.encoder))+"="+p(l(y,s.encoder))]:[p(r)+"="+p(String(y))];var h,v=[];if(void 0===y)return v;if(Array.isArray(c))h=c;else{var g=Object.keys(y);h=u?g.sort(u):g}for(var b=0;b<h.length;++b){var w=h[b];a&&null===y[w]||(v=Array.isArray(y)?v.concat(e(y[w],o(r,w),o,i,a,l,c,u,f,d,p,m)):v.concat(e(y[w],r+(f?"."+w:"["+w+"]"),o,i,a,l,c,u,f,d,p,m)))}return v};e.exports=function(e,t){var r=e,a=t?n.assign({},t):{};if(null!==a.encoder&&void 0!==a.encoder&&"function"!=typeof a.encoder)throw new TypeError("Encoder has to be a function.");var c=void 0===a.delimiter?s.delimiter:a.delimiter,u="boolean"==typeof a.strictNullHandling?a.strictNullHandling:s.strictNullHandling,f="boolean"==typeof a.skipNulls?a.skipNulls:s.skipNulls,d="boolean"==typeof a.encode?a.encode:s.encode,p="function"==typeof a.encoder?a.encoder:s.encoder,m="function"==typeof a.sort?a.sort:null,y=void 0!==a.allowDots&&a.allowDots,h="function"==typeof a.serializeDate?a.serializeDate:s.serializeDate,v="boolean"==typeof a.encodeValuesOnly?a.encodeValuesOnly:s.encodeValuesOnly;if(void 0===a.format)a.format=o.default;else if(!Object.prototype.hasOwnProperty.call(o.formatters,a.format))throw new TypeError("Unknown format option provided.");var g,b,w=o.formatters[a.format];"function"==typeof a.filter?r=(b=a.filter)("",r):Array.isArray(a.filter)&&(g=b=a.filter);var j,O=[];if("object"!=typeof r||null===r)return"";j=a.arrayFormat in i?a.arrayFormat:"indices"in a?a.indices?"indices":"repeat":"indices";var A=i[j];g||(g=Object.keys(r)),m&&g.sort(m);for(var C=0;C<g.length;++C){var x=g[C];f&&null===r[x]||(O=O.concat(l(r[x],x,A,u,f,d?p:null,b,m,y,h,w,v)))}var F=O.join(c),_=!0===a.addQueryPrefix?"?":"";return F.length>0?_+F:""}},DDCP:function(e,t,r){"use strict";var n=r("p8xL"),o=Object.prototype.hasOwnProperty,i={allowDots:!1,allowPrototypes:!1,arrayLimit:20,decoder:n.decode,delimiter:"&",depth:5,parameterLimit:1e3,plainObjects:!1,strictNullHandling:!1},a=function(e,t,r){if(e){var n=r.allowDots?e.replace(/\.([^.[]+)/g,"[$1]"):e,i=/(\[[^[\]]*])/g,a=/(\[[^[\]]*])/.exec(n),s=a?n.slice(0,a.index):n,l=[];if(s){if(!r.plainObjects&&o.call(Object.prototype,s)&&!r.allowPrototypes)return;l.push(s)}for(var c=0;null!==(a=i.exec(n))&&c<r.depth;){if(c+=1,!r.plainObjects&&o.call(Object.prototype,a[1].slice(1,-1))&&!r.allowPrototypes)return;l.push(a[1])}return a&&l.push("["+n.slice(a.index)+"]"),function(e,t,r){for(var n=t,o=e.length-1;o>=0;--o){var i,a=e[o];if("[]"===a)i=(i=[]).concat(n);else{i=r.plainObjects?Object.create(null):{};var s="["===a.charAt(0)&&"]"===a.charAt(a.length-1)?a.slice(1,-1):a,l=parseInt(s,10);!isNaN(l)&&a!==s&&String(l)===s&&l>=0&&r.parseArrays&&l<=r.arrayLimit?(i=[])[l]=n:i[s]=n}n=i}return n}(l,t,r)}};e.exports=function(e,t){var r=t?n.assign({},t):{};if(null!==r.decoder&&void 0!==r.decoder&&"function"!=typeof r.decoder)throw new TypeError("Decoder has to be a function.");if(r.ignoreQueryPrefix=!0===r.ignoreQueryPrefix,r.delimiter="string"==typeof r.delimiter||n.isRegExp(r.delimiter)?r.delimiter:i.delimiter,r.depth="number"==typeof r.depth?r.depth:i.depth,r.arrayLimit="number"==typeof r.arrayLimit?r.arrayLimit:i.arrayLimit,r.parseArrays=!1!==r.parseArrays,r.decoder="function"==typeof r.decoder?r.decoder:i.decoder,r.allowDots="boolean"==typeof r.allowDots?r.allowDots:i.allowDots,r.plainObjects="boolean"==typeof r.plainObjects?r.plainObjects:i.plainObjects,r.allowPrototypes="boolean"==typeof r.allowPrototypes?r.allowPrototypes:i.allowPrototypes,r.parameterLimit="number"==typeof r.parameterLimit?r.parameterLimit:i.parameterLimit,r.strictNullHandling="boolean"==typeof r.strictNullHandling?r.strictNullHandling:i.strictNullHandling,""===e||null===e||void 0===e)return r.plainObjects?Object.create(null):{};for(var s="string"==typeof e?function(e,t){for(var r={},n=t.ignoreQueryPrefix?e.replace(/^\?/,""):e,a=t.parameterLimit===1/0?void 0:t.parameterLimit,s=n.split(t.delimiter,a),l=0;l<s.length;++l){var c,u,f=s[l],d=f.indexOf("]="),p=-1===d?f.indexOf("="):d+1;-1===p?(c=t.decoder(f,i.decoder),u=t.strictNullHandling?null:""):(c=t.decoder(f.slice(0,p),i.decoder),u=t.decoder(f.slice(p+1),i.decoder)),o.call(r,c)?r[c]=[].concat(r[c]).concat(u):r[c]=u}return r}(e,r):e,l=r.plainObjects?Object.create(null):{},c=Object.keys(s),u=0;u<c.length;++u){var f=c[u],d=a(f,s[f],r);l=n.merge(l,d,r)}return n.compact(l)}},EHwe:function(e,t){},QC2t:function(e,t){},T7tn:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=r("dnS4"),o={name:"addPlayer",data:function(){return{ruleForm:{name:"",imageUrl:"",imageInEndUrl:""}}},methods:{submitForm:function(e){var t=this;this.$refs[e].validate(function(e){if(!e)return alert("添加失败!!"),!1;var n=r("mw3O");t.$axios.post("/api/player/withImg",n.stringify({name:t.ruleForm.name,imgSrc:t.ruleForm.imageInEndUrl}),{headers:{"Content-Type":"application/x-www-form-urlencoded"}}).then(function(e){console.info(e),alert("添加成功")})})},resetForm:function(e){this.$refs[e].resetFields()},handleAvatarSuccess:function(e,t){this.ruleForm.imageUrl=URL.createObjectURL(t.raw),this.ruleForm.imageInEndUrl=e.url.slice(n.a.imageIndexStart)},beforeAvatarUpload:function(e){var t="image/jpeg"===e.type,r=e.size/1024/1024<2;return t||this.$message.error("上传头像图片只能是 JPG 格式!"),r||this.$message.error("上传头像图片大小不能超过 2MB!"),t&&r}}},i={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",[r("el-form",{ref:"ruleForm",staticClass:"demo-ruleForm",attrs:{model:e.ruleForm,rules:e.rules,"label-width":"100px"}},[r("div",{staticClass:"theName"},[r("el-form-item",{attrs:{label:"姓名",prop:"name"}},[r("el-input",{model:{value:e.ruleForm.name,callback:function(t){e.$set(e.ruleForm,"name",t)},expression:"ruleForm.name"}})],1)],1),e._v(" "),r("div",{staticClass:"theUpImg"},[r("p",{staticClass:"theUpImgText"},[e._v("上传头像")]),e._v(" "),r("el-upload",{staticClass:"avatar-uploader",attrs:{action:"/api/file/upload","show-file-list":!1,"on-success":e.handleAvatarSuccess,"before-upload":e.beforeAvatarUpload}},[e.ruleForm.imageUrl?r("img",{staticClass:"avatar",attrs:{src:e.ruleForm.imageUrl}}):r("i",{staticClass:"el-icon-plus avatar-uploader-icon"})])],1),e._v(" "),r("el-form-item",{staticClass:"theButtons"},[r("el-button",{attrs:{type:"primary"},on:{click:function(t){return e.submitForm("ruleForm")}}},[e._v("立即创建")]),e._v(" "),r("el-button",{on:{click:function(t){return e.resetForm("ruleForm")}}},[e._v("重置")])],1)],1)],1)},staticRenderFns:[]};var a=r("VU/8")(o,i,!1,function(e){r("EHwe")},null,null);t.default=a.exports},XgCd:function(e,t,r){"use strict";var n=String.prototype.replace,o=/%20/g;e.exports={default:"RFC3986",formatters:{RFC1738:function(e){return n.call(e,o,"+")},RFC3986:function(e){return e}},RFC1738:"RFC1738",RFC3986:"RFC3986"}},dnS4:function(e,t,r){"use strict";t.a={imageIndexStart:8}},m7uW:function(e,t){},mVbX:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=r("3Lce"),o=r("vMJZ"),i={name:"choose",created:function(){var e=this;Object(o.a)().then(function(t){var r;(console.info(t),t.data.id===n.a.errorSessionId)&&(e.$Notice.warning({title:"Notification title",desc:"Session 失效",duration:2}),clearTimeout(r),r=setTimeout(function(){},1e3),e.$router.push("/start/admit"))})},data:function(){return{activeName:"1",testImg:"http://127.0.0.1:7899/img/202111/-a9268a8bc16e425db56db70687d4e7a6.jpg"}},methods:{toShaLeague:function(){this.$router.push("/main")},toOthers:function(){this.$Message.warning("暂时没有")}}},a={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"choose"},[r("div",{staticClass:"buttonList"},[r("div",{staticClass:"button1"},[r("Button",{attrs:{type:"success",size:"large"},on:{click:function(t){return e.toShaLeague()}}},[e._v("杀超联赛")])],1),e._v(" "),r("Button",{attrs:{type:"info",size:"large"},on:{click:function(t){return e.toOthers()}}},[e._v("其他Jay空间")])],1)])},staticRenderFns:[]};var s=r("VU/8")(i,a,!1,function(e){r("m7uW")},null,null);t.default=s.exports},mw3O:function(e,t,r){"use strict";var n=r("CwSZ"),o=r("DDCP"),i=r("XgCd");e.exports={formats:i,parse:o,stringify:n}},p8xL:function(e,t,r){"use strict";var n=Object.prototype.hasOwnProperty,o=function(){for(var e=[],t=0;t<256;++t)e.push("%"+((t<16?"0":"")+t.toString(16)).toUpperCase());return e}(),i=function(e,t){for(var r=t&&t.plainObjects?Object.create(null):{},n=0;n<e.length;++n)void 0!==e[n]&&(r[n]=e[n]);return r};e.exports={arrayToObject:i,assign:function(e,t){return Object.keys(t).reduce(function(e,r){return e[r]=t[r],e},e)},compact:function(e){for(var t=[{obj:{o:e},prop:"o"}],r=[],n=0;n<t.length;++n)for(var o=t[n],i=o.obj[o.prop],a=Object.keys(i),s=0;s<a.length;++s){var l=a[s],c=i[l];"object"==typeof c&&null!==c&&-1===r.indexOf(c)&&(t.push({obj:i,prop:l}),r.push(c))}return function(e){for(var t;e.length;){var r=e.pop();if(t=r.obj[r.prop],Array.isArray(t)){for(var n=[],o=0;o<t.length;++o)void 0!==t[o]&&n.push(t[o]);r.obj[r.prop]=n}}return t}(t)},decode:function(e){try{return decodeURIComponent(e.replace(/\+/g," "))}catch(t){return e}},encode:function(e){if(0===e.length)return e;for(var t="string"==typeof e?e:String(e),r="",n=0;n<t.length;++n){var i=t.charCodeAt(n);45===i||46===i||95===i||126===i||i>=48&&i<=57||i>=65&&i<=90||i>=97&&i<=122?r+=t.charAt(n):i<128?r+=o[i]:i<2048?r+=o[192|i>>6]+o[128|63&i]:i<55296||i>=57344?r+=o[224|i>>12]+o[128|i>>6&63]+o[128|63&i]:(n+=1,i=65536+((1023&i)<<10|1023&t.charCodeAt(n)),r+=o[240|i>>18]+o[128|i>>12&63]+o[128|i>>6&63]+o[128|63&i])}return r},isBuffer:function(e){return null!==e&&void 0!==e&&!!(e.constructor&&e.constructor.isBuffer&&e.constructor.isBuffer(e))},isRegExp:function(e){return"[object RegExp]"===Object.prototype.toString.call(e)},merge:function e(t,r,o){if(!r)return t;if("object"!=typeof r){if(Array.isArray(t))t.push(r);else{if("object"!=typeof t)return[t,r];(o.plainObjects||o.allowPrototypes||!n.call(Object.prototype,r))&&(t[r]=!0)}return t}if("object"!=typeof t)return[t].concat(r);var a=t;return Array.isArray(t)&&!Array.isArray(r)&&(a=i(t,o)),Array.isArray(t)&&Array.isArray(r)?(r.forEach(function(r,i){n.call(t,i)?t[i]&&"object"==typeof t[i]?t[i]=e(t[i],r,o):t.push(r):t[i]=r}),t):Object.keys(r).reduce(function(t,i){var a=r[i];return n.call(t,i)?t[i]=e(t[i],a,o):t[i]=a,t},a)}}},s2w0:function(e,t,r){"use strict";Object.defineProperty(t,"__esModule",{value:!0});var n=r("IcnI"),o={name:"admit",inject:["reload"],created:function(){this.getQustion()},data:function(){return{theQuestion:"",theQuestionId:"",inputAnswer:""}},methods:{getQustion:function(){var e=this;this.$axios.get("/api/enterQuestion/getAQuestionByRand").then(function(t){e.theQuestionId=t.data.data.qid,e.theQuestion=t.data.data.qdescription,console.info(e.theQuestionId)})},checkAnswer:function(){var e=this;this.$axios.post("/api/enterQuestion/checkAnswer",{id:this.theQuestionId.toString(),Qanswer:this.inputAnswer}).then(function(t){if(200===t.data.code){var r=e.$createElement;e.$message({message:r("p",null,[r("span",null,"回答"),r("i",{style:"color: teal"},"正确")])}),n.a.dispatch("user/fetchUserInfo"),e.$router.push("/start/choose")}else{var o=e.$createElement;e.$message({message:o("p",null,[o("span",null,"回答"),o("i",{style:"color: #ff1111"},"错误")])}),e.reload()}})}}},i={render:function(){var e=this,t=e.$createElement,r=e._self._c||t;return r("div",{staticClass:"theQuestion"},[r("p",{staticClass:"staticSaying"},[e._v("请回答下述问题\n  ")]),e._v(" "),r("p",{staticClass:"theDynamicQues"},[e._v(e._s(e.theQuestion)+"\n  ")]),e._v(" "),r("div",{staticClass:"theInput"},[r("el-input",{attrs:{placeholder:"请输入答案",clearable:""},model:{value:e.inputAnswer,callback:function(t){e.inputAnswer=t},expression:"inputAnswer"}})],1),e._v(" "),r("el-button",{attrs:{type:"success",round:""},on:{click:function(t){return e.checkAnswer()}}},[e._v("提交回答")])],1)},staticRenderFns:[]};var a=r("VU/8")(o,i,!1,function(e){r("QC2t")},"data-v-3f0e1a9b",null);t.default=a.exports}});