import { PlaywrightTestConfig, devices } from '@playwright/test'

const config: PlaywrightTestConfig = {
  globalSetup: require.resolve('./test/global-setup'),
  testDir: 'test/spec',
  workers: 5,
  retries: 1
  export default defineConfig({
    use: {
      testIdAttribute: 'id'
    }
}

export default config