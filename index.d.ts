declare module '@apiverve/cardgenerator' {
  export interface cardgeneratorOptions {
    api_key: string;
    secure?: boolean;
  }

  export interface cardgeneratorResponse {
    status: string;
    error: string | null;
    data: any;
    code?: number;
  }

  export default class cardgeneratorWrapper {
    constructor(options: cardgeneratorOptions);

    execute(callback: (error: any, data: cardgeneratorResponse | null) => void): Promise<cardgeneratorResponse>;
    execute(query: Record<string, any>, callback: (error: any, data: cardgeneratorResponse | null) => void): Promise<cardgeneratorResponse>;
    execute(query?: Record<string, any>): Promise<cardgeneratorResponse>;
  }
}
