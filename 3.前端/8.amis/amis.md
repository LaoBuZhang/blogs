# amis

## amis

amis 是一个低代码前端框架，它使用 JSON 配置来生成页面，可以减少页面开发工作量，极大提升效率。

使用方法和jquery类似，都是引用后再js标签中编写json语句

配合amis 可视化编辑器，能够快速开发简单常用的前端页面



## 地址

[amisgithub地址](https://github.com/baidu/amis)



[amis文档](https://aisuda.bce.baidu.com/amis/zh-CN/docs/index)

可以查看amis具体的格式，组件，数据类型等信息



[amis 可视化编辑器示例](https://github.com/aisuda/amis-editor-demo)

有网页版本，甚至不用自己本地部署



## 使用

amis 的依赖可以使用外部 cdn

但是为了稳定请在自己部署的时候将文件下载到本地。





### 外部cdn

地址

~~~html
<link
  rel="stylesheet"
  title="default"
  href="https://unpkg.com/amis@beta/sdk/sdk.css"
/>
<link
  rel="stylesheet"
  href="https://unpkg.com/amis@beta/sdk/helper.css"
/>
<link
  rel="stylesheet"
  href="https://unpkg.com/amis@beta/sdk/iconfont.css"
/>
<script src="https://unpkg.com/amis@beta/sdk/sdk.js"></script>
~~~





### 本地cdn

==将依赖下载到index.html同目录下==

1. 终端执行`npm init`，将文件夹初始化
2. 执行`npm i amis`，将amis依赖下载到文件夹内



文件目录：

![image-20230207221349786](images/image-20230207221349786.png)

node_modules中存放的就是一些依赖





==编写index.html==

- 注意链接的地址要根据使用的cdn位置进行修改
- 外部cdn就把上边网址写进去
- `let amisJSON =` 后边的内容填写amis格式的json语句

~~~html
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="UTF-8" />
    <title>amis demo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1"
    />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <link rel="stylesheet" href="sdk.css" />
    <link rel="stylesheet" href="helper.css" />
    <link rel="stylesheet" href="iconfont.css" />
    <!-- 这是默认主题所需的，如果是其他主题则不需要 -->
    <!-- 从 1.1.0 开始 sdk.css 将不支持 IE 11，如果要支持 IE11 请引用这个 css，并把前面那个删了 -->
    <!-- <link rel="stylesheet" href="sdk-ie11.css" /> -->
    <!-- 不过 amis 开发团队几乎没测试过 IE 11 下的效果，所以可能有细节功能用不了，如果发现请报 issue -->
    <style>
      html,
      body,
      .app-wrapper {
        position: relative;
        width: 100%;
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="root" class="app-wrapper"></div>
    <script src="sdk.js"></script>
    <script type="text/javascript">
      (function () {
        let amis = amisRequire('amis/embed');
        
        let amisJSON = 
        // 通过替换下面这个配置来生成不同页面
        {
          type: 'page',
          title: '表单页面',
          body: {
            type: 'form',
            mode: 'horizontal',
            api: '/saveForm',
            body: [
              {
                label: 'Name',
                type: 'input-text',
                name: 'name'
              },
              {
                label: 'Email',
                type: 'input-email',
                name: 'email'
              }
            ]
          }
        };
        // 通过替换上面这个配置来生成不同页面
          
        let amisScoped = amis.embed('#root', amisJSON);
      })();
    </script>
  </body>
</html>
~~~







### 可视化编辑器

[amis 可视化编辑器示例](https://github.com/aisuda/amis-editor-demo)



amis在线可视化编辑器

[AMIS 页面 (aisuda.github.io)](https://aisuda.github.io/amis-editor-demo)



再可视化编辑器中拖动组件创建页面，即可生成相应的json语句，将json语句复制到html中替换相应的部分即可实现对应页面效果



下面的页面就是使用可视化编辑器生成json后直接复制进html

~~~html
<!DOCTYPE html>
<html lang="zh">
  <head>
    <meta charset="UTF-8" />
    <title>amis demo</title>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta
      name="viewport"
      content="width=device-width, initial-scale=1, maximum-scale=1"
    />
    <meta http-equiv="X-UA-Compatible" content="IE=Edge" />
    <link rel="stylesheet" href="./node_modules/amis/sdk/sdk.css" />
    <link rel="stylesheet" href="./node_modules/amis/sdk/helper.css" />
    <link rel="stylesheet" href="./node_modules/amis/sdk/iconfont.css" />
    <!-- 这是默认主题所需的，如果是其他主题则不需要 -->
    <!-- 从 1.1.0 开始 sdk.css 将不支持 IE 11，如果要支持 IE11 请引用这个 css，并把前面那个删了 -->
    <!-- <link rel="stylesheet" href="sdk-ie11.css" /> -->
    <!-- 不过 amis 开发团队几乎没测试过 IE 11 下的效果，所以可能有细节功能用不了，如果发现请报 issue -->
    <style>
      html,
      body,
      .app-wrapper {
        position: relative;
        width: 100%;
        height: 100%;
        margin: 0;
        padding: 0;
      }
    </style>
  </head>
  <body>
    <div id="root" class="app-wrapper"></div>
    <script src="./node_modules/amis/sdk/sdk.js"></script>
    <script type="text/javascript">
      (function () {
        let amis = amisRequire('amis/embed');
        // 通过替换下面这个配置来生成不同页面
        let amisJSON = {
          "type": "page",
          "title": "人员管理系统",
          "body": [
            {
              "type": "grid",
              "columns": [
              ],
              "id": "u:3f2a3adfe591"
            },
            {
              "type": "tabs",
              "tabs": [
                {
                  "title": "选项卡1",
                  "body": [
                    {
                      "type": "switch",
                      "label": "模式切换",
                      "option": "",
                      "name": "switch",
                      "falseValue": false,
                      "trueValue": true,
                      "id": "u:b9243d91bfd4",
                      "value": false,
                      "remark": "",
                      "hidden": false
                    },
                    {
                      "type": "crud",
                      "syncLocation": false,
                      "api": {
                        "method": "get",
                        "url": "http://www.baidu.com"
                      },
                      "columns": [
                        {
                          "name": "id",
                          "label": "ID",
                          "type": "text",
                          "id": "u:75dd5c36f1ab"
                        },
                        {
                          "name": "name",
                          "label": "姓名",
                          "type": "text",
                          "id": "u:d211abeb60a4"
                        },
                        {
                          "type": "text",
                          "label": "性别",
                          "name": "sex",
                          "id": "u:0b6ada07d298"
                        },
                        {
                          "type": "text",
                          "label": "年龄",
                          "name": "age",
                          "id": "u:cbdacef71297"
                        },
                        {
                          "type": "text",
                          "label": "工作",
                          "name": "work",
                          "id": "u:9bbe9bf715d4"
                        },
                        {
                          "type": "operation",
                          "label": "操作",
                          "buttons": [
                            {
                              "label": "编辑",
                              "type": "button",
                              "actionType": "dialog",
                              "level": "link",
                              "dialog": {
                                "title": "编辑",
                                "body": {
                                  "type": "form",
                                  "api": "xxx/update",
                                  "body": [
                                    {
                                      "name": "id",
                                      "label": "ID",
                                      "type": "input-text",
                                      "id": "u:d3d6facac643"
                                    },
                                    {
                                      "name": "name",
                                      "label": "姓名",
                                      "type": "input-text",
                                      "id": "u:fcd2a3354cdb"
                                    },
                                    {
                                      "label": "性别",
                                      "name": "sex",
                                      "type": "input-text",
                                      "id": "u:513a15aa8088"
                                    },
                                    {
                                      "label": "年龄",
                                      "name": "age",
                                      "type": "input-text",
                                      "id": "u:8cd6fe7c7437"
                                    },
                                    {
                                      "label": "工作",
                                      "name": "work",
                                      "type": "input-text",
                                      "id": "u:aad3d7faa784"
                                    }
                                  ],
                                  "id": "u:85e987c7526f"
                                }
                              },
                              "id": "u:a314d3c43699"
                            },
                            {
                              "label": "查看",
                              "type": "button",
                              "actionType": "dialog",
                              "level": "link",
                              "dialog": {
                                "title": "查看详情",
                                "body": {
                                  "type": "form",
                                  "api": "xxx/update",
                                  "body": [
                                    {
                                      "name": "id",
                                      "label": "ID",
                                      "type": "static",
                                      "id": "u:0a117c836582"
                                    },
                                    {
                                      "name": "name",
                                      "label": "姓名",
                                      "type": "static",
                                      "id": "u:95b7816e19d1"
                                    },
                                    {
                                      "label": "性别",
                                      "name": "sex",
                                      "type": "static",
                                      "id": "u:c9e0c5df52cb"
                                    },
                                    {
                                      "label": "年龄",
                                      "name": "age",
                                      "type": "static",
                                      "id": "u:946f2a97b6eb"
                                    },
                                    {
                                      "label": "工作",
                                      "name": "work",
                                      "type": "static",
                                      "id": "u:d24990630cbd"
                                    }
                                  ],
                                  "id": "u:319e5f682e44"
                                }
                              },
                              "id": "u:ac696ae96cf9"
                            },
                            {
                              "type": "button",
                              "label": "删除",
                              "actionType": "ajax",
                              "level": "link",
                              "className": "text-danger",
                              "confirmText": "确定要删除？",
                              "api": {
                                "method": "post",
                                "url": "http://www.baidu.com"
                              },
                              "id": "u:c0e3bb5d14b6"
                            }
                          ],
                          "id": "u:7521e5e9b786"
                        }
                      ],
                      "bulkActions": [
                        {
                          "type": "button",
                          "level": "danger",
                          "label": "批量删除",
                          "actionType": "ajax",
                          "confirmText": "确定要删除？",
                          "api": "/xxx/batch-delete",
                          "id": "u:786bca3304c9"
                        },
                        {
                          "type": "button",
                          "label": "批量编辑",
                          "actionType": "dialog",
                          "dialog": {
                            "title": "批量编辑",
                            "size": "md",
                            "body": {
                              "type": "form",
                              "api": "/xxx/bacth-edit",
                              "body": [
                                {
                                  "label": "字段1",
                                  "text": "字段1",
                                  "type": "input-text",
                                  "id": "u:2968bfcbcdf6"
                                }
                              ],
                              "id": "u:345c4f4c9f76"
                            }
                          },
                          "id": "u:143a2dddd5b5"
                        }
                      ],
                      "itemActions": [
                      ],
                      "features": [
                        "create",
                        "bulkDelete",
                        "bulkUpdate",
                        "update",
                        "filter",
                        "view",
                        "delete"
                      ],
                      "filterColumnCount": 5,
                      "headerToolbar": [
                        {
                          "label": "新增",
                          "type": "button",
                          "actionType": "dialog",
                          "level": "primary",
                          "dialog": {
                            "title": "新增",
                            "body": {
                              "type": "form",
                              "api": {
                                "method": "post",
                                "url": "http://www.baidu.com"
                              },
                              "body": [
                                {
                                  "type": "input-text",
                                  "name": "id",
                                  "label": "ID",
                                  "id": "u:d199ff52dae9"
                                },
                                {
                                  "type": "input-text",
                                  "name": "name",
                                  "label": "姓名",
                                  "id": "u:4ea72d8ea670"
                                },
                                {
                                  "type": "input-text",
                                  "name": "sex",
                                  "label": "性别",
                                  "id": "u:1ddafd5b371a"
                                },
                                {
                                  "type": "input-text",
                                  "name": "age",
                                  "label": "年龄",
                                  "id": "u:2aa02eaed235"
                                },
                                {
                                  "type": "input-text",
                                  "name": "work",
                                  "label": "工作",
                                  "id": "u:f37f23bec77c"
                                }
                              ],
                              "id": "u:9f7515b57592"
                            }
                          },
                          "id": "u:672ba7cb4085"
                        },
                        "bulkActions"
                      ],
                      "id": "u:6f99cb7299d8"
                    },
                    {
                      "type": "textarea",
                      "label": "问题收集：",
                      "name": "longtext",
                      "id": "u:1bbef7066b8b",
                      "minRows": 3,
                      "maxRows": 20,
                      "value": "请输入你的问题~~~",
                      "showCounter": true
                    }
                  ],
                  "id": "u:2b15a7535a7a"
                },
                {
                  "title": "选项卡2",
                  "body": [
                    {
                      "type": "matrix-checkboxes",
                      "name": "matrix",
                      "label": "矩阵开关",
                      "rowLabel": "行标题说明",
                      "columns": [
                        {
                          "label": "列1"
                        },
                        {
                          "label": "列2"
                        }
                      ],
                      "rows": [
                        {
                          "label": "行1"
                        },
                        {
                          "label": "行2"
                        }
                      ],
                      "id": "u:6b2809b1c3bb"
                    }
                  ],
                  "id": "u:a58c62da46e7"
                }
              ],
              "id": "u:466f2c2f2e37",
              "toolbar": [
                {
                  "type": "dropdown-button",
                  "label": "下拉按钮",
                  "buttons": [
                    {
                      "type": "button",
                      "label": "按钮1",
                      "onEvent": {
                        "click": {
                          "actions": [
                          ]
                        }
                      },
                      "id": "u:fa6eb50261f4"
                    },
                    {
                      "type": "button",
                      "label": "按钮2",
                      "onEvent": {
                        "click": {
                          "actions": [
                          ]
                        }
                      },
                      "id": "u:e7e17aacdf06"
                    }
                  ],
                  "id": "u:67c41c70f2d0"
                }
              ]
            },
            {
              "type": "flex",
              "className": "p-1",
              "items": [
              ],
              "style": {
                "position": "static"
              },
              "direction": "row",
              "justify": "flex-start",
              "alignItems": "stretch",
              "id": "u:3e1487148bde"
            }
          ],
          "id": "u:a03f9157aa00",
          "toolbar": [
            {
              "type": "flex",
              "className": "p-1",
              "items": [
                {
                  "type": "container",
                  "body": [
                  ],
                  "size": "xs",
                  "style": {
                    "position": "static",
                    "display": "block",
                    "flex": "1 1 auto",
                    "flexGrow": 1,
                    "flexBasis": "auto"
                  },
                  "wrapperBody": false,
                  "isFixedHeight": false,
                  "isFixedWidth": false,
                  "id": "u:51ab2957e93f"
                },
                {
                  "type": "container",
                  "body": [
                  ],
                  "size": "xs",
                  "style": {
                    "position": "static",
                    "display": "block",
                    "flex": "1 1 auto",
                    "flexGrow": 1,
                    "flexBasis": "auto"
                  },
                  "wrapperBody": false,
                  "isFixedHeight": false,
                  "isFixedWidth": false,
                  "id": "u:6bf8a1c69201"
                },
                {
                  "type": "container",
                  "body": [
                  ],
                  "size": "xs",
                  "style": {
                    "position": "static",
                    "display": "block",
                    "flex": "1 1 auto",
                    "flexGrow": 1,
                    "flexBasis": "auto"
                  },
                  "wrapperBody": false,
                  "isFixedHeight": false,
                  "isFixedWidth": false,
                  "id": "u:6bf8a1c69201"
                },
                {
                  "type": "container",
                  "body": [
                  ],
                  "size": "xs",
                  "style": {
                    "position": "static",
                    "display": "block",
                    "flex": "1 1 auto",
                    "flexGrow": 1,
                    "flexBasis": "auto"
                  },
                  "wrapperBody": false,
                  "isFixedHeight": false,
                  "isFixedWidth": false,
                  "id": "u:51ab2957e93f"
                },
                {
                  "type": "container",
                  "body": [
                  ],
                  "size": "xs",
                  "style": {
                    "position": "static",
                    "display": "block",
                    "flex": "1 1 auto",
                    "flexGrow": 1,
                    "flexBasis": "auto"
                  },
                  "wrapperBody": false,
                  "isFixedHeight": false,
                  "isFixedWidth": false,
                  "id": "u:51ab2957e93f"
                },
                {
                  "type": "container",
                  "body": [
                  ],
                  "size": "xs",
                  "style": {
                    "position": "static",
                    "display": "block",
                    "flex": "1 1 auto",
                    "flexGrow": 1,
                    "flexBasis": "auto"
                  },
                  "wrapperBody": false,
                  "isFixedHeight": false,
                  "isFixedWidth": false,
                  "id": "u:2514618f34b6"
                },
                {
                  "type": "container",
                  "body": [
                  ],
                  "size": "xs",
                  "style": {
                    "position": "static",
                    "display": "block",
                    "flex": "1 1 auto",
                    "flexGrow": 1,
                    "flexBasis": "auto"
                  },
                  "wrapperBody": false,
                  "isFixedHeight": false,
                  "isFixedWidth": false,
                  "id": "u:51ab2957e93f"
                },
                {
                  "type": "container",
                  "body": [
                    {
                      "type": "dropdown-button",
                      "label": "下拉按钮",
                      "buttons": [
                        {
                          "type": "button",
                          "label": "按钮1",
                          "onEvent": {
                            "click": {
                              "actions": [
                              ]
                            }
                          },
                          "id": "u:42569074f583"
                        },
                        {
                          "type": "button",
                          "label": "按钮2",
                          "onEvent": {
                            "click": {
                              "actions": [
                              ]
                            }
                          },
                          "id": "u:d27b647913e2"
                        }
                      ],
                      "id": "u:c6b71e3b26d9"
                    }
                  ],
                  "size": "xs",
                  "style": {
                    "position": "static",
                    "display": "block",
                    "flex": "1 1 auto",
                    "flexGrow": 1,
                    "flexBasis": "auto"
                  },
                  "wrapperBody": false,
                  "isFixedHeight": false,
                  "isFixedWidth": false,
                  "id": "u:b57fa05e4879"
                }
              ],
              "style": {
                "position": "static"
              },
              "direction": "row",
              "justify": "flex-start",
              "alignItems": "stretch",
              "id": "u:bfb73283de76"
            }
          ],
          "subTitle": "amis开发",
          "remark": "",
          "asideResizor": true,
          "pullRefresh": {
            "disabled": true
          },
          "asideSticky": true,
          "aside": [
            {
              "type": "input-tree",
              "label": "位置",
              "name": "tree",
              "options": [
                {
                  "label": "选项A",
                  "value": "A",
                  "children": [
                    {
                      "label": "选项C",
                      "value": "C"
                    },
                    {
                      "label": "选项D",
                      "value": "D"
                    }
                  ]
                },
                {
                  "label": "选项B",
                  "value": "B"
                }
              ],
              "id": "u:2fc1595a731b",
              "multiple": false,
              "enableNodePath": false,
              "hideRoot": true,
              "showIcon": true,
              "initiallyOpen": true,
              "value": ""
            }
          ],
          "regions": [
            "body",
            "toolbar",
            "header",
            "aside"
          ],
          "style": {
            "fontFamily": "",
            "fontSize": 12
          }
        };
        let amisScoped = amis.embed('#root', amisJSON);
      })();
    </script>
  </body>
</html>
~~~

