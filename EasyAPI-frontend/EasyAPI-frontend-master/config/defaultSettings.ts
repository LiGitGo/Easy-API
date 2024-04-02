import { Settings as LayoutSettings } from '@ant-design/pro-components';

/**
 * @name
 */
const Settings: LayoutSettings & {
  pwa?: boolean;
  logo?: string;
} = {
  "navTheme": "light",
  "layout": "mix",
  "contentWidth": "Fluid",
  "fixedHeader": false,
  "fixSiderbar": true,
  "colorPrimary": "#1677FF",
  "splitMenus": false,
  "siderMenuType": "sub",
  title: 'Easy-API',
  pwa: false,
  logo: 'https://pic.rmb.bdstatic.com/dd6571822e6b289d7a46ae1f4b57860d.jpeg',
  iconfontUrl: '',
};

export default Settings;


